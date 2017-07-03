package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Curtir;
import br.com.crescer.social.service.CurtirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author chris
 */

@RestController
public class CurtirController {
    
    //usar ng-if para curtir e descurtir
    @Autowired public CurtirService curtirService;
    
    @PostMapping(value = "/curtir/{id}")
    public void adicionarCurtir(@RequestBody Curtir curtir, @AuthenticationPrincipal User usuario, @PathVariable Long id) {
        curtirService.save(curtir, usuario, id);
    }
    
    @PostMapping(value = "/descurtir/{id}")
    public void retirarCurtir(@PathVariable Long id) {
        curtirService.delete(id);
    }
    
}
