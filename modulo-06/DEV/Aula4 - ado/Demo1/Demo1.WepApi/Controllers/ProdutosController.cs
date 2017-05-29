using Demo1.WepApi.Models;
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
        public IHttpActionResult Post(Produto produto)
        {
            if (produto.Estoque < 1)
                return BadRequest("Estoque deve ser maior que zero.");

            if (produto.Preco < 0.01M)
                return BadRequest("Preço deve ser maior que zero.");

            if (string.IsNullOrWhiteSpace(produto.Nome))
                return BadRequest("Nome deve ser informado.");

            string stringConexao = "Server=13.65.101.67;User Id=christopher.michel;Password=123456;Database=aluno11db";

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"INSERT INTO Produto (Nome, Preco, Estoque) 
                        VALUES (@nome, @preco, @estoque)";

                    comando.Parameters.AddWithValue("@nome", produto.Nome);
                    comando.Parameters.AddWithValue("@preco", produto.Preco);
                    comando.Parameters.AddWithValue("@estoque", produto.Estoque);

                    // Executa o comando e retorna somente a quantidade de linhas afetadas
                    comando.ExecuteNonQuery();

                    // Lê o resultado de um SELECT
                    // comando.ExecuteReader();

                    // Executa o comando e retorna o primeiro resultado
                    // comando.ExecuteScalar();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    var result = (decimal)comando.ExecuteScalar();
                    // Executa o comando e retorna o primeiro resultado
                    produto.Id = (int)result;
                }
            }
            return Ok(produto);
        }
    }
}
