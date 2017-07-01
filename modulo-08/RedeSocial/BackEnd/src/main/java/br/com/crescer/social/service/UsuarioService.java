package br.com.crescer.social.service;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepositorio;
    
    public List<Usuario> findAll() {
        return (List)usuarioRepositorio.findAll();
    }
    
    public Usuario post(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuarioRepositorio.save(usuario);
    }
        
    public Usuario getById(Long id) {
        return usuarioRepositorio.findOne(id);
    }
    
    public Usuario getByEmail (String email) {
        return usuarioRepositorio.getByEmail(email);
    }
    
    public void remove(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }
    
    public Usuario put(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
    
    public void enviarSolicitacaoDeAmizade(Usuario mandaSolicitacao, Usuario recebeSolicitacao) {
        recebeSolicitacao.getSolicitacoes().add(mandaSolicitacao);
        put(recebeSolicitacao);
    }
    
    public void aceitarSolicitacaoDeAmizade(Usuario recebeSolicitacao, Usuario mandaSolicitacao) {
        recebeSolicitacao.getSolicitacoes().remove(mandaSolicitacao);
        recebeSolicitacao.getAmigos().add(mandaSolicitacao);
        mandaSolicitacao.getAmigos().add(recebeSolicitacao);
        put(recebeSolicitacao);
        put(mandaSolicitacao);
    }

}
