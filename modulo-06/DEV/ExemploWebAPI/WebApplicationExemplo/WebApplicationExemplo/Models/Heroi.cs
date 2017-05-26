using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WebApplicationExemplo.Models;

namespace WebApplicationExemplo.Models
{
    public class Heroi
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public Poder Poder { get; set; }
    }

}