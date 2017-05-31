using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public AutorRepositorio()
        {
        }

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public Livro Deletar(int Id)
        {
            var autor = contexto.Livros.First(cadaUm => cadaUm.IdAutor == Id);
            contexto.Livros.Remove(autor);
            contexto.SaveChanges();
            return autor;
        }
    }
}
