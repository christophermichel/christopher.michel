using EditoraCrescer.Api.App_Start;
using EditoraCrescer.Infraestrutura;
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
    [RoutePrefix("api/Autores")]
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();

        [HttpGet]
        public IHttpActionResult Obter()
        {
            return Ok(new { dados = repositorio.Obter() });
        }

        
        [HttpGet]
        [Route("{id:int}/livros")]
        public IHttpActionResult ObterLivrosPorIdAutor(int id)
        {
            return Ok(new { dados = repositorio.ObterLivrosPorIdAutor(id) });
        }

        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult ObterAutorPorId(int id)
        {
            return Ok(new { dados = repositorio.ObterAutorPorId(id) });
        }

        [HttpPost]
        public IHttpActionResult Criar(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok();
        }

        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult Alterar(Autor autor)
        {
            repositorio.Alterar(autor);
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
