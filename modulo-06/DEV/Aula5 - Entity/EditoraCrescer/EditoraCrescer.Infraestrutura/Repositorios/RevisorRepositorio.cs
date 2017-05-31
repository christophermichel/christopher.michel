using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public RevisorRepositorio()
        {
        }

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public void Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public Revisor Deletar(int Id)
        {
            var revisor = contexto.Revisores.First(cadaUm => cadaUm.Id == Id);
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
            return revisor;
        }
    }
}
