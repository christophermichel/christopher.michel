using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class HeroisController : ApiController
    {
        public int ultimoId { get; set; } = 0;

        public static object objetoLock = new object();

        private static List<Heroi> herois = new List<Heroi>();
        
               // new Heroi() { Id = 2, Nome = "Luffy", Poder = new Poder() { Nome = "Gear Third", Dano = 7000 } },
               // new Heroi() { Id = 3, Nome = "Ryu", Poder = new Poder() { Nome = "Hadouken", Dano = 9000 } },
               // new Heroi() { Id = 4, Nome = "Uchiha Madara", Poder = new Poder() { Nome = "Susano", Dano = 6000 } }
        

        public IEnumerable<Heroi> Get(string nome = null, int? id = null)
        {
            return herois;
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            lock (objetoLock)
            {
                herois.Add(heroi);
                heroi.Id = ++ultimoId;
                return Ok(heroi);
            }  
        }
    }
}
