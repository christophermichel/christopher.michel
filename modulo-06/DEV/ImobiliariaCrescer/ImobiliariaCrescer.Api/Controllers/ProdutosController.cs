using ImobiliariaCrescer.Dominio.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ImobiliariaCrescer.Api.Controllers
{
    [RoutePrefix("api/produtos")]
    public class ProdutosController : ApiController
    {
        private ProdutoRepositorio repositorio = new ProdutoRepositorio();

        /*
        //get adicionais
        [Route("adicionais")]
        [HttpGet]
        public HttpResponseMessage ObterAdicionais()
        {
            var produtos = repositorio.ObterAdicionais();
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = produtos });
        }

        //get combos
        [Route("adicionais")]
        [HttpGet]
        public HttpResponseMessage ObterCombos()
        {
            var produtos = repositorio.ObterCombos();
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = produtos });
        }*/

        //get por id
        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterProdutoPorId(int id)
        {
            var produto = repositorio.ObterPorId(id);
            if (produto.Equals(null))
            {
                return Request.CreateResponse(HttpStatusCode.NotFound, new { alert = "Não há registros com o ID informado." });
            }
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = produto });
        }

        //post
        [HttpPost]
        public IHttpActionResult Post(Produto produto)
        {
            repositorio.Criar(produto);
            return Ok();
        }

    }
}