package br.com.crescer.aula7.repositorios;
import br.com.crescer.aula7.entidades.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

}