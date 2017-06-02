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
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        [HttpGet]
        public IHttpActionResult Obter()
        {
            return Ok(new { dados = repositorio.Obter() });
        }

        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult ObterRevisorPorId(int id)
        {
            return Ok(new { dados = repositorio.ObterRevisorPorId(id) });
        }

        [HttpPost]
        public IHttpActionResult Criar(Revisor revisor)
        {
            repositorio.Criar(revisor);
            return Ok();
        }

        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult Alterar(Revisor revisor)
        {
            repositorio.Alterar(revisor);
            return Ok();
        }

        [HttpDelete]
        [Route("{id}")]
        public IHttpActionResult Deletar(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }
    }
}
