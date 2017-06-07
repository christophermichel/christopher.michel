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

        public Pedido ObterPorId(int id)
        {
            return contexto.Pedidos
                           .FirstOrDefault(x => x.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
