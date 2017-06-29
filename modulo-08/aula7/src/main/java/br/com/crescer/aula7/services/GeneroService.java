package br.com.crescer.aula7.services;
import br.com.crescer.aula7.entidades.Genero;
import br.com.crescer.aula7.repositorios.GeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepositorio;
    
    public List<Genero> findAll() {
        return (List)generoRepositorio.findAll();
    }
    
    public Genero post(Genero genero) {
        return generoRepositorio.save(genero);
    }
        
    public Genero getGeneroById(Long id) {
        return generoRepositorio.findOne(id);
    }
    
    public void remove(Genero genero) {
        generoRepositorio.delete(genero);
    }

}