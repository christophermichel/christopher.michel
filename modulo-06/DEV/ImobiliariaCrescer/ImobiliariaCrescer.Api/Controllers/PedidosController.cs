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
    [RoutePrefix("api/pedidos")]
    public class PedidosController : ApiController
    {
        private PedidoRepositorio repositorio = new PedidoRepositorio();

        //get com orderby por data

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

        [Route("{id:int}")]
        [HttpPut]
        public HttpResponseMessage Alterar(int id, Pedido pedido)
        {
            repositorio.Alterar(id, pedido);
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = pedido });
        }


    }
}
