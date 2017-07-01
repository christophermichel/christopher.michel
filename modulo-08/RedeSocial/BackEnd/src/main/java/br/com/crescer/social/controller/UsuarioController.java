package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired UsuarioService usuarioService; 
        
    @GetMapping("/usuario")
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }
        
    @PostMapping("/usuario")
    public void post(@RequestBody Usuario usuario) {
        usuarioService.post(usuario);
    }
    
    @GetMapping("/usuario/{id}")
    public Usuario getById(@PathVariable Long id) {
        return usuarioService.getById(id);
    }
    
    @DeleteMapping("/usuario/{id}")
    public void remove(@PathVariable Long id) {
        usuarioService.remove(usuarioService.getById(id));
    }
    
    @PostMapping(value = "/usuario/solicitacao/{id}")
    public void solicitacaoDeAmizade(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Usuario mandouSolicitacao = usuarioService.getByEmail(user.getUsername());
        Usuario recebeuSolicitacao = usuarioService.getById(id);
        usuarioService.enviarSolicitacaoDeAmizade(mandouSolicitacao, recebeuSolicitacao);
    }
    
    @PostMapping(value = "/usuario/aceitar/{id}")
    public void aceitarConvite(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Usuario recebeuSolicitacao = usuarioService.getByEmail(user.getUsername());
        Usuario mandouSolicitacao = usuarioService.getById(id);
        usuarioService.aceitarSolicitacaoDeAmizade(recebeuSolicitacao, mandouSolicitacao);
    }
}