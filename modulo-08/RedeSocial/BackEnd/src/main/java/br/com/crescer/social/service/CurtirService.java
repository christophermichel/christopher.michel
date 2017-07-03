package br.com.crescer.social.service;

import br.com.crescer.social.entity.Curtir;
import br.com.crescer.social.repository.CurtirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class CurtirService {
    
    @Autowired private CurtirRepository curtirRepositorio;
    
    @Autowired private PostService postService;
    
    @Autowired private UsuarioService usuarioService;
    
    public Curtir save(Curtir curtir, User usuario, Long idPost) {
        curtir.setUsuarioCurtir(usuarioService.getByEmail(usuario.getUsername()));
        curtir.setPost(postService.getById(idPost));
        return curtirRepositorio.save(curtir);
    }
    
    public void delete(Long id) {
        curtirRepositorio.delete(id);
    }
    
}
