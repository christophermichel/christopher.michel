package br.com.crescer.social.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
 * @author christopher.michel
 */
@Entity
public class Relacionamento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_RELACIONAMENTO")
    @SequenceGenerator(name = "SEQ_RELACIONAMENTO", sequenceName = "SEQ_RELACIONAMENTO", allocationSize = 1)
    @Basic(optional = true)
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @JoinColumn(name = "ID_mandouConvite")
    private Usuario mandouConvite;

    @Basic(optional = false)
    @JoinColumn(name = "ID_recebeuConvite")
    private Usuario recebeuConvite;
    
    @Basic(optional = false)
    @Column(name = "RELACAO")
    private String relacao;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getMandouConvite() {
        return mandouConvite;
    }

    public void setMandouConvite(Usuario mandouConvite) {
        this.mandouConvite = mandouConvite;
    }

    public Usuario getRecebeuConvite() {
        return recebeuConvite;
    }

    public void setRecebeuConvite(Usuario recebeuConvite) {
        this.recebeuConvite = recebeuConvite;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }
    
    
}
