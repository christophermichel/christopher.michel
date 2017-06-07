using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura;

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

        public void Criar(Pedido pedido)
        {
            contexto.Pedidos.Add(pedido);
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
