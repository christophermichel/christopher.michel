using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public RevisorRepositorio()
        {
        }

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor ObterUsuarioPorId(int id)
        {
            return contexto.Revisores.FirstOrDefault(x => x.Id == id);
        }

        public void Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public void Alterar(Revisor revisor)
        {
            contexto.Entry(revisor).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public Revisor Deletar(int Id)
        {
            var revisor = contexto.Revisores.First(cadaUm => cadaUm.Id == Id);
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
            return revisor;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
