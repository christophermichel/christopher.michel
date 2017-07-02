package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Post;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author chris
 */
public interface PostRepository extends CrudRepository<Post, Long>{
    
    public List<Post> findByIdUsuario (Long id);
    
}
