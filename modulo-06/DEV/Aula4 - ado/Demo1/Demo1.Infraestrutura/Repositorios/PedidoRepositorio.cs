using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao = "Server=13.65.101.67;User Id=christopher.michel;Password=123456;Database=aluno11db";

        public void Alterar(Pedido pedido)
        {
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "INSERT INTO Pedido (NomeCliente) VALUES (@nomeCliente)";
                    comando.CommandTimeout = 120;

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    comando.CommandTimeout = 120;

                    var resultado = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)resultado;
                }

                using (var comando = conexao.CreateCommand())
                {
                    foreach (var itemPedido in pedido.Itens)
                    {
                        comando.CommandText = "INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) VALUES (@pedidoId, @produtoId, @quantidade)";
                        comando.CommandTimeout = 120;

                        comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@produtoId", itemPedido.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", itemPedido.Quantidade);

                        comando.ExecuteNonQuery();

                        comando.CommandText = "UPDATE Produto SET Estoque -= @quantidade WHERE Id = @itemProdutoId";

                        comando.Parameters.AddWithValue("@itemProdutoId", itemPedido.ProdutoId);

                        comando.ExecuteNonQuery();

                        comando.Parameters.Clear();
                    }
                }
            }
        }

        public void Excluir(int id)
        {
        }

        public IEnumerable<Pedido> Listar()
        {
            var listaPedidos = new List<Pedido>();
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT (id, nomeCliente, Itens)
                                          FROM Pedido";
                    var dataReader = comando.ExecuteReader();
                    do
                    {
                        var pedido = new Pedido();

                        pedido.Id = (int)dataReader["id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = (List<ItemPedido>)dataReader["Itens"];

                        listaPedidos.Add(pedido);
                    }

                    while (dataReader.Read());
                }
            }
            return listaPedidos;
        }

        public Pedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}
