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
            return contexto.Livros
                           .Select(x => new
                            {
                                Isbn = x.Isbn,
                                Titulo = x.Titulo,
                                Capa = x.Capa,
                                NomeAutor = x.Autor,
                                ObterPorGenero = x.Genero
                            })
                            .ToList();
        }

        public Livro ObterPorId(int id)
        {
            var livro = contexto.Livros.First(cadaUm => cadaUm.Isbn == id);
            return livro;
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
                                NomeAutor = x.Autor,
                                ObterPorGenero = x.Genero
                            })
                            .ToList();
        }

        public dynamic ObterLancamentos()
        {
            return contexto.Livros
                           .Where(cadaUm => ((DateTime.Now - cadaUm.DataPublicacao).TotalDays) >= 7)
                           .Select(x => new
                           {
                               Isbn = x.Isbn,
                               Titulo = x.Titulo,
                               Capa = x.Capa,
                               NomeAutor = x.Autor,
                               ObterPorGenero = x.Genero
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
