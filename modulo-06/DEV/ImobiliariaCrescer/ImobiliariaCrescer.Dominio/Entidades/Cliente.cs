using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public int CPF { get; set; }
        public int Telefone { get; set; }
        public string Endereco { get; set; }
        public char Genero { get; set; }
        public DateTime DataDeNascimento { get; set; }

        protected Cliente () { }

        public Cliente (string Nome, int CPF, int telefone, string Endereco, char Genero, DateTime DataDeNascimento)
        {
            this.Nome = Nome;
            this.CPF = CPF;
            this.Telefone = telefone;
            this.Endereco = Endereco;
            this.Genero = Genero;
            this.DataDeNascimento = DataDeNascimento;
        }
    }
}
