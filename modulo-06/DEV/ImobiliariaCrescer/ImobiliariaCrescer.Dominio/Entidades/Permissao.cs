using System;
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Permissao
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }

        protected Permissao () { }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}
