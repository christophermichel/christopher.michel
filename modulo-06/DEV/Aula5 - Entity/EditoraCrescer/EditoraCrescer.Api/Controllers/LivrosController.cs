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
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        
        [HttpGet]
        public IHttpActionResult ObterTodos()
        {
            var livros = repositorio.Obter();
            return Ok(new { dados = livros });
        }

        [HttpGet]
        [Route("Lancamentos")]
        public IHttpActionResult ObterLancamentos()
        {
            var livros = repositorio.ObterLancamentos();
            return Ok(new { dados = livros });
        }

        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var livro = repositorio.ObterPorId(id);
            return Ok(new { dados = livro });
        }

        [Route("{genero}")]
        [HttpGet]
        public IHttpActionResult ObterPorGenero(string genero)
        {
            var livro = repositorio.ObterPorGenero(genero);
            return Ok(new { dados = livro });
        }

        [HttpPost]
        public IHttpActionResult Criar(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok(new { dados = livro });
        }

        [HttpPut]
        [Route("{isbn}")]
        public IHttpActionResult Alterar (Livro livro)
        {
            repositorio.Alterar(livro);
            return Ok(new { dados = livro });
        }

        [HttpDelete]
        [Route("{isbn}")]
        public IHttpActionResult Deletar(int Isbn)
        {
            return Ok(new { dados = repositorio.Deletar(Isbn) });
        }
    }
}