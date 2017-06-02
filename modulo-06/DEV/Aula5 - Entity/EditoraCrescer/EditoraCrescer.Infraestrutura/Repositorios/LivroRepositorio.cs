using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public LivroRepositorio()
        {
        }

        public dynamic Obter()
        {
            return contexto.Livros.ToList();
        }

        public dynamic ObterResumido()
        {
            return contexto.Livros
                           .Select(x => new
                            {
                                Isbn = x.Isbn,
                                Titulo = x.Titulo,
                                Capa = x.Capa,
                                NomeAutor = x.Autor.Nome
                            })
                            .ToList();
        }

        public Livro ObterPorId(int id)
        {
            return contexto.Livros.FirstOrDefault(x => x.Isbn == id);
                                  
        }

        public dynamic ObterPorGenero(string genero)
        {
            return contexto.Livros
                            .Where(x => x.Genero.Contains(genero))
                            .Select(x => new
                            {
                                Isbn = x.Isbn,
                                Titulo = x.Titulo,
                                Capa = x.Capa,
                                NomeAutor = x.Autor.Nome,
                                Genero = x.Genero
                            })
                            .ToList();
        }

        public dynamic ObterLancamentos()
        {
            var seteDiasAtras = DateTime.Now.AddDays(-7);

            return contexto.Livros
                           .Where(x => (x.DataPublicacao > seteDiasAtras))
                           .Select(x => new
                           {
                                Isbn = x.Isbn,
                                Titulo = x.Titulo,
                                Capa = x.Capa,
                                NomeAutor = x.Autor.Nome,
                                Genero = x.Genero
                            })
                            .ToList();
        }

        public void Alterar(Livro livro)
        {
            contexto.Entry(livro).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public Livro Deletar(int id)
        {
            var livro = contexto.Livros.First(cadaUm => cadaUm.Isbn == id);
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
            return livro;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
