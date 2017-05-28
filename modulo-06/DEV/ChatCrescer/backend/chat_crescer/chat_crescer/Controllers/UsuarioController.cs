using chat_crescer.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace chat_crescer.Controllers
{
    public class UsuarioController : ApiController
    {
        public static List<Usuario> Usuarios = new List<Usuario>();
        private static int IdUsuario = 0;
        private object locker = new object();

        public IEnumerable<Usuario> Get()
        {
            return Usuarios;
        }

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario != null)
            {
                lock (locker)
                {
                    Usuarios.Add(usuario);
                    usuario.Id = ++IdUsuario;
                    return Ok(usuario);
                }
            }
            else
            {
                return BadRequest();
            }
        }
    }
}