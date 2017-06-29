package br.com.crescer.aula7.services;
import br.com.crescer.aula7.entidades.Locacao;
import br.com.crescer.aula7.repositorios.LocacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepositorio;
    
    public List<Locacao> findAll() {
        return (List)locacaoRepositorio.findAll();
    }
    
    public Locacao post(Locacao locacao) {
        return locacaoRepositorio.save(locacao);
    }
        
    public Locacao getLocacaoById(Long id) {
        return locacaoRepositorio.findOne(id);
    }
    
    public void remove(Locacao locacao) {
        locacaoRepositorio.delete(locacao);
    }

}