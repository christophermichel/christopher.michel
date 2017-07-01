package br.com.crescer.social.service;

import br.com.crescer.social.entity.Post;
import br.com.crescer.social.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepositorio;
    
    public List<Post> findAll() {
        return (List)postRepositorio.findAll();
    }
    
    public Post post(Post post) {
        return postRepositorio.save(post);
    }
        
    public Post getById(Long id) {
        return postRepositorio.findOne(id);
    }
    
    public void remove(Post post) {
        postRepositorio.delete(post);
    }

}
