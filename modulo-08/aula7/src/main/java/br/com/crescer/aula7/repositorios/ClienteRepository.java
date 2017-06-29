package br.com.crescer.aula7.repositorios;
import br.com.crescer.aula7.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}