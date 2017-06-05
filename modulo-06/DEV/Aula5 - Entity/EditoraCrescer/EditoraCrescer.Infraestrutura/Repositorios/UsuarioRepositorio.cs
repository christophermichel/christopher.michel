using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public UsuarioRepositorio()
        {
        }

        public List<Usuario> Obter()
        {
            return contexto.Usuarios.ToList();
        }

        public Usuario ObterUsuarioPorId(int id)
        {
            return contexto.Usuarios.FirstOrDefault(x => x.Id == id);
        }

        public void Criar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}