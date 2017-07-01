package br.com.crescer.social.repository;
import br.com.crescer.social.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
    public Usuario getByEmail(String email);

}