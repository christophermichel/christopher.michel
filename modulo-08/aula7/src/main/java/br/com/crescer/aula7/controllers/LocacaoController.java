package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.entidades.Locacao;
import br.com.crescer.aula7.services.LocacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocacaoController {

    @Autowired LocacaoService locacaoService; 
        
    @GetMapping("/locacao")
    public List<Locacao> findAll() {
        return locacaoService.findAll();
    }
        
    @PostMapping("/locacao")
    public void post(@RequestBody Locacao locacao) {
        locacaoService.post(locacao);
    }
    
    @GetMapping("/locacao/{id}")
    public Locacao getById(@PathVariable Long id) {
        return locacaoService.getLocacaoById(id);
    }
    
    @DeleteMapping("/locacao/{id}")
    public void remove(@PathVariable Long id) {
        locacaoService.remove(locacaoService.getLocacaoById(id));
    }
    
}