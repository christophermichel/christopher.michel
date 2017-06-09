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
            return contexto.Pedidos.ToList()
                                   .Where(cadaUm => cadaUm.DataEntrega != null)
                                   .OrderBy(cadaUm => cadaUm.DataVencimento);
                                  
        }

        public dynamic ObterAlugados()
        {
            return contexto.Pedidos.ToList()
                                   .Where(cadaUm => cadaUm.DataEntrega == null)
                                   .OrderBy(cadaUm => cadaUm.DataVencimento);

        }

        public void Criar(Pedido padrao)
        {
            Pedido pedido = new Pedido(padrao.Cliente, padrao.Itens, padrao.DataVencimento);
            contexto.Entry(pedido.Cliente).State = EntityState.Unchanged;

            foreach (var item in pedido.Itens)
            {
                contexto.Entry(item.Produto).State = EntityState.Unchanged;
            }
            contexto.Pedidos.Add(pedido);
            contexto.SaveChanges();
        }

        public void Alterar(int id, Pedido pedido)
        {
            contexto.Entry(pedido).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
