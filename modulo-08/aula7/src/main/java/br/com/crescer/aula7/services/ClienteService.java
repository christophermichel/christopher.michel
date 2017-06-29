package br.com.crescer.aula7.services;
import br.com.crescer.aula7.entidades.Cliente;
import br.com.crescer.aula7.repositorios.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepositorio;
    
    public List<Cliente> findAll() {
        return (List)clienteRepositorio.findAll();
    }
    
    public Cliente post(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }
        
    public Cliente getClienteById(Long id) {
        return clienteRepositorio.findOne(id);
    }
    
    public void remove(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }

}