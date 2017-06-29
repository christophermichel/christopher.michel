package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.entidades.Cliente;
import br.com.crescer.aula7.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired ClienteService clienteService; 
        
    @GetMapping("/cliente")
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }
        
    @PostMapping("/cliente")
    public void post(@RequestBody Cliente cliente) {
        clienteService.post(cliente);
    }
    
    @GetMapping("/cliente/{id}")
    public Cliente getById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }
    
    @DeleteMapping("/cliente/{id}")
    public void remove(@PathVariable Long id) {
        clienteService.remove(clienteService.getClienteById(id));
    }
    
}