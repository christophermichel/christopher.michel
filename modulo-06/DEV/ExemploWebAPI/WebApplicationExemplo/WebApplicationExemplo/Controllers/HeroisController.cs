using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebApplicationExemplo.Models;

namespace WebApplicationExemplo.Controllers
{
    public class HeroisController : ApiController
    {
        public IList<Heroi> Get()
        {
            var herois = new List<Heroi>()
            {
                new Heroi() { Id = 1, Nome = "Goku", Poder = new Poder() { Nome = "Genki Dama", Dano = 8000 } },
                new Heroi() { Id = 2, Nome = "Goku", Poder = new Poder() { Nome = "Genki Dama", Dano = 8000 } },
                new Heroi() { Id = 3, Nome = "Goku", Poder = new Poder() { Nome = "Genki Dama", Dano = 8000 } },
                new Heroi() { Id = 4, Nome = "Goku", Poder = new Poder() { Nome = "Genki Dama", Dano = 8000 } }
            };

            return herois;
        }

        public IHttpActionResult Post (Heroi heroi)
        {
            return Ok();
            //if (heroi.Id == 0)
            //{
                //Salva no banco de dados
             //   return Ok();
            //}
            //else
              //  return BadRequest();
        }
    }
}
