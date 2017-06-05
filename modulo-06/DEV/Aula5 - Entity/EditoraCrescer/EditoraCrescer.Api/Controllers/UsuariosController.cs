using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Usuarios")]
    public class UsuariosController : ApiController
    {
        private UsuarioRepositorio repositorio = new UsuarioRepositorio();

        [HttpGet]
        public IHttpActionResult Obter()
        {
            return Ok(new { dados = repositorio.Obter() });
        }

        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult ObterUsuarioPorId(int id)
        {
            return Ok(new { dados = repositorio.ObterUsuarioPorId(id) });
        }

        [HttpPost]
        public IHttpActionResult Criar(Usuario usuario)
        {
            repositorio.Criar(usuario);
            return Ok();
        }

    }
}
