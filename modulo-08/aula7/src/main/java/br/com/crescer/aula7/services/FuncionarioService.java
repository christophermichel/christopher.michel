package br.com.crescer.aula7.services;
import br.com.crescer.aula7.entidades.Funcionario;
import br.com.crescer.aula7.repositorios.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepositorio;
    
    public List<Funcionario> findAll() {
        return (List)funcionarioRepositorio.findAll();
    }
    
    public Funcionario post(Funcionario funcionario) {
        return funcionarioRepositorio.save(funcionario);
    }
        
    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepositorio.findOne(id);
    }
    
    public void remove(Funcionario funcionario) {
        funcionarioRepositorio.delete(funcionario);
    }

}