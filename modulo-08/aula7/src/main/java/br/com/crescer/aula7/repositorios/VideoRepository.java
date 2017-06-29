package br.com.crescer.aula7.repositorios;
import br.com.crescer.aula7.entidades.Video;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface VideoRepository extends CrudRepository<Video, Long> {

}