package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.entidades.Genero;
import br.com.crescer.aula7.services.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneroController {

    @Autowired GeneroService generoService; 
        
    @GetMapping("/genero")
    public List<Genero> findAll() {
        return generoService.findAll();
    }
        
    @PostMapping("/genero")
    public void post(@RequestBody Genero genero) {
        generoService.post(genero);
    }
    
    @GetMapping("/genero/{id}")
    public Genero getById(@PathVariable Long id) {
        return generoService.getGeneroById(id);
    }
    
    @DeleteMapping("/genero/{id}")
    public void remove(@PathVariable Long id) {
        generoService.remove(generoService.getGeneroById(id));
    }
    
}