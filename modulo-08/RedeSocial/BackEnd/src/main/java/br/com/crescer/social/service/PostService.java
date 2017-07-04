package br.com.crescer.social.service;

import br.com.crescer.social.entity.Post;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.repository.PostRepository;
import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepositorio;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public List<Post> findAll() {
        return (List)postRepositorio.findAll();
    }
            
    public Post getById(Long id) {
        return postRepositorio.findOne(id);
    }   
    
    public List<Post> getPostsAmigos(User user) {
        Set<Usuario> amigosUser = usuarioService.getByEmail(user.getUsername()).getAmigos();
        return postRepositorio.findByIdUsuarioOrderById(amigosUser);
    }
    
    public Post post(Post post) {
        post.setDataPublicacao(new Date());
        return postRepositorio.save(post);
    }

    public void remove(Post post) {
        postRepositorio.delete(post);
    }
    
    public List<Post> findPostsById(Long id) {
        return usuarioService.getById(id).getPosts();
    }
}
