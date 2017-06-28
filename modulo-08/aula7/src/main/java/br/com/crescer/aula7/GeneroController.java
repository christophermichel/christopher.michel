package br.com.crescer.aula7;

import br.com.crescer.aula7.Genero;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneroController {

    @Autowired GeneroService generoService; 
    
    @GetMapping("/genero")
    public List<Genero> findAll() {
        return generoService.findAll();
    }
    
    @PostMapping("/genero")
    public void addGenero(@RequestBody Genero genero) {
        generoService.addGenero(genero);
    }
}