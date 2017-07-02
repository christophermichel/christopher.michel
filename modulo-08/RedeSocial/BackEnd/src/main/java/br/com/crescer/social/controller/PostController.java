package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Post;
import br.com.crescer.social.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired PostService postService; 
        
    @GetMapping("/post")
    public List<Post> findAll() {
        return postService.findAll();
    }
    
    @GetMapping("/post/usuario/{id}")
    public List<Post> getPostsById(@PathVariable Long id) {
        return postService.findPostsById(id);
    }
        
    @PostMapping("/post")
    public void post(@RequestBody Post post) {
        postService.post(post);
    }
    
    @GetMapping("/post/{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getById(id);
    }
    
    @DeleteMapping("/post/{id}")
    public void remove(@PathVariable Long id) {
        postService.remove(postService.getById(id));
    }
    
}