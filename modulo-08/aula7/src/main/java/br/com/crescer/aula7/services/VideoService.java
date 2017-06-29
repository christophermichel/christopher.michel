package br.com.crescer.aula7.services;
import br.com.crescer.aula7.entidades.Video;
import br.com.crescer.aula7.repositorios.VideoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepositorio;
    
    public List<Video> findAll() {
        return (List)videoRepositorio.findAll();
    }
    
    public Video post(Video video) {
        return videoRepositorio.save(video);
    }
        
    public Video getGeneroById(Long id) {
        return videoRepositorio.findOne(id);
    }
    
    public void remove(Video video) {
        videoRepositorio.delete(video);
    }

}