package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Post;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author chris
 */
public interface PostRepository extends CrudRepository<Post, Long>{
    
}
