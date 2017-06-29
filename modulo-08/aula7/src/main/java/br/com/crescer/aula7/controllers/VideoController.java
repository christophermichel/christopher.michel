package br.com.crescer.aula7.controllers;


import br.com.crescer.aula7.entidades.Video;
import br.com.crescer.aula7.services.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @Autowired VideoService videoService; 
        
    @GetMapping("/video")
    public List<Video> findAll() {
        return videoService.findAll();
    }
        
    @PostMapping("/video")
    public void post(@RequestBody Video video) {
        videoService.post(video);
    }
    
    @GetMapping("/video/{id}")
    public Video getById(@PathVariable Long id) {
        return videoService.getGeneroById(id);
    }
    
    @DeleteMapping("/video/{id}")
    public void remove(@PathVariable Long id) {
        videoService.remove(videoService.getGeneroById(id));
    }
    
}