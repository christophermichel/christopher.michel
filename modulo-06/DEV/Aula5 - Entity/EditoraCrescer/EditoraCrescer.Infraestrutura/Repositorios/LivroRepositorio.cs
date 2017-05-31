using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public LivroRepositorio()
        {
        }

        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public Livro ObterPorId(int id)
        {
            var livro = contexto.Livros.First(cadaUm => cadaUm.Isbn == id);
            return livro;
        }

        public Livro Alterar(int id)
        {
            var livro = contexto.Livros.FirstOrDefault(cadaUm => cadaUm.Isbn == id);
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return livro;
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

    }
}
