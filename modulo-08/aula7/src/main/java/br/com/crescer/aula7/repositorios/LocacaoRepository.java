package br.com.crescer.aula7.repositorios;
import br.com.crescer.aula7.entidades.Locacao;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface LocacaoRepository extends CrudRepository<Locacao, Long> {

}