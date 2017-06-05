using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    class Pedido
    {
        public int Id { get; set; }
        public int IdCliente { get; set; }
        public List <Produto> Itens { get; set; }
        public DateTime DataPedido { get; set; }
        public decimal ValorTotal { get; set; }
        public DateTime DataEntrega { get; set; }
        public DateTime DataVencimento { get; set; }
    }
}
