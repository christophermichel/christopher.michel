package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.entidades.Funcionario;
import br.com.crescer.aula7.services.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {

    @Autowired FuncionarioService funcionarioService; 
        
    @GetMapping("/funcionario")
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }
        
    @PostMapping("/funcionario")
    public void post(@RequestBody Funcionario funcionario) {
        funcionarioService.post(funcionario);
    }
    
    @GetMapping("/funcionario/{id}")
    public Funcionario getById(@PathVariable Long id) {
        return funcionarioService.getFuncionarioById(id);
    }
    
    @DeleteMapping("/funcionario/{id}")
    public void remove(@PathVariable Long id) {
        funcionarioService.remove(funcionarioService.getFuncionarioById(id));
    }
    
}