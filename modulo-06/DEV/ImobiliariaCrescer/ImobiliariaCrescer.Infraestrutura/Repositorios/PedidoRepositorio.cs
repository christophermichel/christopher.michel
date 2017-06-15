using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura;
using System.Data.Entity;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public PedidoRepositorio()
        {
        }

        public Pedido ObterPorId(int id)
        {
            return contexto.Pedidos
                           .FirstOrDefault(x => x.Id == id);
        }

        public dynamic ObterPorData()
        {
            return contexto.Pedidos.Include(x => x.Cliente).Include(x => x.Itens)
                                   .Where(cadaUm => cadaUm.DataEntrega != null)
                                   .OrderBy(cadaUm => cadaUm.DataVencimento);
                                  
        }

        public dynamic ObterAlugados()
        {
            return contexto.Pedidos.ToList()
                                   .Where(cadaUm => cadaUm.DataEntrega == null)
                                   .OrderBy(cadaUm => cadaUm.DataVencimento);

        }

        public dynamic RelatorioMensal()
        {
            var pedidos = contexto.Pedidos
                                  .Include(x => x.Cliente)
                                  .Include(x=>x.Itens)
                                  .ToList();
            return pedidos.Where(x => (DateTime.Now - x.DataPedido)
                          .TotalDays <= 30)
                          .ToList();
        }

        public dynamic RelatorioAtrasados()
        {
            var atrasados = contexto.Pedidos
                                    .Include(x => x.Itens)
                                    .Include(x => x.Cliente)
                                    .ToList();

            return atrasados.Where(x => (x.DataVencimento - DateTime.Now).TotalDays < 0)
                            .OrderBy(x => x.DataVencimento)
                            .ToList();

        }

        public void Criar(Pedido padrao)
        {
            Pedido pedido = new Pedido(padrao.Cliente, padrao.Itens, padrao.DataVencimento);
            contexto.Entry(pedido.Cliente).State = EntityState.Unchanged;
            contexto.Pedidos.Add(pedido);

            foreach (var item in pedido.Itens)
            {
                contexto.Entry(item.Produto).State = EntityState.Unchanged;
            }
            DescontarQuantidade(pedido);
            contexto.SaveChanges();
        }

        private void DescontarQuantidade(Pedido pedido)
        {
            ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();
            foreach (var item in pedido.Itens)
            {
                var produto = produtoRepositorio.ObterPorId(item.Produto.Id);
                if (produto.Quantidade > 0)
                {
                    produto.BaixarEstoque();
                }
                produtoRepositorio.Alterar(produto.Id, produto);
                contexto.SaveChanges();
            }
        }

        public void Devolver(int id)
        {
            var pedido = contexto.Pedidos.FirstOrDefault(e => e.Id == id);
            pedido.DataEntrega = DateTime.Now;
            //CalcularAtraso(pedido);
            contexto.Entry(pedido).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

        }

        public void Alterar(int id, Pedido pedido)
        {
            contexto.Entry(pedido).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        //colocar dentro do pedido
        private void CalcularAtraso(Pedido pedido)
        {
            var diasDeAtraso = (pedido.DataVencimento - pedido.DataEntrega.Value).TotalDays;
            if (diasDeAtraso < 0)
            {
                var multa = (Convert.ToDecimal(diasDeAtraso) * pedido.ValorTotal);
                var novoValor = pedido.ValorTotal + multa;
                pedido.ValorTotal = novoValor;
            }
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
