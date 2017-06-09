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

        public void Criar(Pedido padrao)
        {
            Pedido pedido = new Pedido(padrao.Cliente, padrao.Itens, padrao.DataVencimento);
            contexto.Entry(pedido.Cliente).State = EntityState.Unchanged;
            contexto.Pedidos.Add(pedido);

            foreach (var item in pedido.Itens)
            {
                contexto.Entry(item.Produto).State = EntityState.Unchanged;
            }
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
