using chat_crescer.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace chat_crescer.Controllers
{
    public class MensagemController : ApiController
    {
        public static List<Mensagem> Mensagens = new List<Mensagem>();
        private static int IdMensagem = 0;
        private object locker = new object();

        public IEnumerable<Mensagem> Get()
        {
            return Mensagens;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (locker)
                {
                    Mensagens.Add(mensagem);
                    mensagem.Id = ++IdMensagem;
                    mensagem.HoraDoEnvio = DateTime.Now;
                    return Ok(mensagem);
                }
            }
        }
    }
}