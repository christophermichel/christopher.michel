using ImobiliariaCrescer.Dominio.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;
using ImobiliariaCrescer.WebApi;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ImobiliariaCrescer.Api.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/pedidos")]
    public class PedidosController : ApiController
    {
        private PedidoRepositorio repositorio = new PedidoRepositorio();

        //get com orderby por data
        [HttpGet]
        public IHttpActionResult Obter()
        {
            return Ok(new { dados = repositorio.ObterPorData() });
        }

        [Route("alugados")]
        [HttpGet]
        public IHttpActionResult ObterAlugados()
        {
            return Ok(new { dados = repositorio.ObterAlugados() });
        }

        [Route("relatorio/mensal")]
        [HttpGet]
        public IHttpActionResult RelatorioMensal()
        {
            return Ok(new { dados = repositorio.RelatorioMensal() });
        }

        //get por id
        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterPedidoPorId(int id)
        {
            var pedido = repositorio.ObterPorId(id);
            if (pedido.Equals(null))
            {
                return Request.CreateResponse(HttpStatusCode.NotFound, new { alert = "Não há registros com o ID informado." });
            }
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = pedido });
        }

        //post
        [HttpPost]
        public IHttpActionResult Post(Pedido pedido)
        {
            repositorio.Criar(pedido);
            return Ok();
        }

        [Route("devolver/{id:int}")]
        [HttpPut]
        public HttpResponseMessage Alterar(int id, Pedido pedido)
        {
            repositorio.Devolver(id, pedido);
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = pedido });
        }


    }
}
