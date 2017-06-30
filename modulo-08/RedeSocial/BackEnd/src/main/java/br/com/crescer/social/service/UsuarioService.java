package br.com.crescer.social.service;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepositorio;
    
    public List<Usuario> findAll() {
        return (List)usuarioRepositorio.findAll();
    }
    
    public Usuario post(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
        
    public Usuario getById(Long id) {
        return usuarioRepositorio.findOne(id);
    }
    
    public void remove(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }

}
