using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public Cliente Cliente { get; set; }
        public List <PedidoProduto> Itens { get; set; }
        public DateTime DataPedido { get; set; }
        public decimal ValorTotal { get; set; }
        public DateTime? DataEntrega { get; set; }
        public DateTime DataVencimento { get; set; }

        protected Pedido() { }

        public Pedido(Cliente cliente, List<PedidoProduto> itens, DateTime dataVencimento)
        {
            this.Cliente = cliente;
            this.Itens = itens;
            this.DataPedido = DateTime.Now;
            this.ValorTotal = itens.Sum(cadaUm => cadaUm.Produto.PrecoDiaria);
            DataVencimento = dataVencimento;

        }
    }
}
