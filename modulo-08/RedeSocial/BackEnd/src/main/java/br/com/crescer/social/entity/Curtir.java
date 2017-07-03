package br.com.crescer.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
/**
 *
 * @author chris
 */

@Entity
public class Curtir implements Serializable {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LIKE")
    @SequenceGenerator(name = "SEQ_LIKE", sequenceName = "SEQ_LIKE", allocationSize = 1)
    @Column(name = "ID_CURTIR")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_CURTIR")
    private Usuario usuarioCurtir;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_POST")
    private Post postCurtir;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioCurtir() {
        return usuarioCurtir;
    }

    public void setUsuarioCurtir(Usuario usuarioCurtir) {
        this.usuarioCurtir = usuarioCurtir;
    }

    public Post getPost() {
        return postCurtir;
    }

    public void setPost(Post postCurtir) {
        this.postCurtir = postCurtir;
    }
}
