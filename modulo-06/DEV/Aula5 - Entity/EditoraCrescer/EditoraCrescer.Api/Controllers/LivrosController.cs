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

    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        
        [HttpGet]
        public IHttpActionResult ObterTodos()
        {
            var livros = repositorio.Obter();
            return Ok(livros);
        }

        [Route("{Isbn}")]
        [HttpGet]
        public IHttpActionResult ObterPorId(int Isbn)
        {
            repositorio.ObterPorId(Isbn);
            return Ok();
        }

        [HttpPost]
        public IHttpActionResult Criar(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok();
        }

        [HttpPut]
        public IHttpActionResult Alterar (int isbn)
        {
            repositorio.Alterar(isbn);
            return Ok();
        }

        [HttpDelete]
        public IHttpActionResult Deletar(int Isbn)
        {
            repositorio.Deletar(Isbn);
            return Ok();
        }
    }
}