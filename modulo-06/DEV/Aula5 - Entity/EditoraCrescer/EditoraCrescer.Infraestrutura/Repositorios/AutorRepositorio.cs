using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public AutorRepositorio()
        {
        }

        public List<Autor> Obter()
        {
            return contexto.Autores
                           .ToList();
        }

        public List<Livro> ObterLivrosPorIdAutor(int id)
        {
            return contexto.Livros
                           .Where(x => x.IdAutor == id)
                           .ToList();
        }

        public Autor ObterAutorPorId(int id)
        {
            return contexto.Autores.FirstOrDefault(x => x.Id == id);
        }

        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Alterar(Autor autor)
        {
            contexto.Entry(autor).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public Autor Deletar(int Id)
        {
            var autor = contexto.Autores.First(cadaUm => cadaUm.Id == Id);
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
            return autor;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
