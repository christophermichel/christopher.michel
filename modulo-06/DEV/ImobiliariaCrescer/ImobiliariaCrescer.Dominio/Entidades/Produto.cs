using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; set; }
        public string Pacote { get; set; }
        public string Tipo { get; set; }
        public int Quantidade { get; set; }
        public decimal PrecoDiaria { get; set; }

        protected Produto() { }

        public Produto(string Pacote, string Tipo, int Quantidade, decimal PrecoDiaria)
        {
            this.Pacote = Pacote;
            this.Tipo = Tipo;
            this.Quantidade = Quantidade;
            this.PrecoDiaria = PrecoDiaria;
        }
    }

}
