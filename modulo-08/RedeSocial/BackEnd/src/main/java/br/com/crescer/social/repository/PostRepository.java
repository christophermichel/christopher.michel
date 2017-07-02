package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Post;
import br.com.crescer.social.entity.Usuario;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author chris
 */
public interface PostRepository extends CrudRepository<Post, Long>{
    
    List<Post> findByIdUsuario(Set<Usuario> usuarios, Pageable pageable);
    
}
