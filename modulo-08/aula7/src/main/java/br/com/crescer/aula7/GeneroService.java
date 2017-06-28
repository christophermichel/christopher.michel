package br.com.crescer.aula7;
import br.com.crescer.aula7.Genero;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    @Autowired 
    GeneroRepository generoRepository;
    
    public List<Genero> findAll() {
        return (List)generoRepository.findAll();
    } 
    
    public void addGenero(Genero genero) {
        generoRepository.save(genero);
    }
}