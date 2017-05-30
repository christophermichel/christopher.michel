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
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var command = conexao.CreateCommand())
                {
                    command.CommandText =
                                            @"UPDATE Pedido SET NomeCliente = @nome 
                                            WHERE Id = @pedidoId";
                    command.Parameters.AddWithValue("nome", pedido.NomeCliente);
                    command.Parameters.AddWithValue("pedidoId", pedido.Id);
                    command.ExecuteNonQuery();
                    command.Parameters.Clear();
                }
            }
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var command = conexao.CreateCommand())
                {
                    command.CommandText =
                                            @"INSERT INTO Pedido (NomeCliente) 
                                            VALUES (@nome)";
                    command.Parameters.AddWithValue("nome", pedido.NomeCliente);
                    command.ExecuteNonQuery();
                    command.Parameters.Clear();

                    foreach (var item in pedido.Itens)
                    {
                        command.CommandText =
                                              @"INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) 
                                              VALUES(@pedidoId, @produtoId, @quantidade)";
                        command.Parameters.AddWithValue("pedidoId", item.Id);
                        command.Parameters.AddWithValue("produtoId", item.ProdutoId);
                        command.Parameters.AddWithValue("quantidade", item.Quantidade);
                        command.ExecuteNonQuery();
                        command.Parameters.Clear();

                        command.CommandText =
                                              @"UPDATE Produto SET Estoque = Estoque -  @quantidade 
                                              WHERE Id = @itemProdutoId";
                        command.Parameters.AddWithValue("quantidade", item.Quantidade);
                        command.Parameters.AddWithValue("itemProdutoId", item.ProdutoId);
                        command.Parameters.Clear();
                    }
                }
                using (var command = conexao.CreateCommand())
                {
                    command.CommandText = "SELECT @@IDENTITY";
                    pedido.Id = (int)(decimal)command.ExecuteScalar();
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
