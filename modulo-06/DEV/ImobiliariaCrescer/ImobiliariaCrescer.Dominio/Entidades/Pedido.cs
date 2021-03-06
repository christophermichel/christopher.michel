﻿using System;
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

        public Pedido(Cliente Cliente, List<PedidoProduto> Itens, DateTime dataVencimento)
        {
            this.Cliente = Cliente;
            this.Itens = Itens;
            this.DataPedido = DateTime.Now;
            this.DataVencimento = dataVencimento;
            var totalDias = (DataVencimento - DataPedido).Days;
            this.ValorTotal = 0;
                //Itens.Sum(cadaUm => (cadaUm.Produto.PrecoDiaria * totalDias));
        
        }
    }
}
