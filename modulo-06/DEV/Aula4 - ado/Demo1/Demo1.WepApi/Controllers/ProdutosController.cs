using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WepApi.Controllers
{
    public class ProdutosController : ApiController
    {
        ProdutoRepositorio _produtorepositorio = new ProdutoRepositorio();

        public IHttpActionResult Post(Produto produto)
        {
            var mensagens = new List<string>();
            if (!produto.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

            return Ok(produto);
        }

        public IHttpActionResult Get()
        {
            var produtos = _produtorepositorio.Listar();
            return Ok(produtos);
        }
    }
}
