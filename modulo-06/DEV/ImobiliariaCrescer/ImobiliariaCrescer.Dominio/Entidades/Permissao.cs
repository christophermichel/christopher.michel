using System;
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Permissao
    {
        public string Nome { get; private set; }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}
