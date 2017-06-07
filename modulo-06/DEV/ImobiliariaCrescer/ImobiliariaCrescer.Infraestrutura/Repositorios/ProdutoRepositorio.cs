using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;
using EditoraCrescer.Infraestrutura;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        /*public List<Produto> ObterAdicionais()
        {
            return contexto.Produtos
                           .Where(produto => produto.Tipo == "adicional")
                           .ToList;
        }

        public List<Produto> ObterCombos()
        {
            return contexto.Produtos
                           .Where(produto => produto.Tipo != "adicional")
                           .ToList;
        }*/

        public Produto ObterPorId(int id)
        {
            return contexto.Produtos
                           .FirstOrDefault(x => x.Id == id);
        }

        public void Criar(Produto produto)
        {
            contexto.Produtos.Add(produto);
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}