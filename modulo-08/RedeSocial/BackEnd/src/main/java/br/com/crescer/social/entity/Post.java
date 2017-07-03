package br.com.crescer.social.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
/**
 *
 * @author chris
 */

@Entity
public class Post implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_POST")
    @SequenceGenerator(name = "SEQ_POST", sequenceName = "SEQ_POST", allocationSize = 1)
    private Long id;
    
    @Basic(optional = false)
    @Size(min = 1, max = 250)
    @Column(name = "IMAGEM")
    private String imagem;
    
    @Basic(optional = false)
    @Size(min = 1, max = 750)
    @Column(name = "CONTEUDO")
    private String conteudo;
    
    @Basic(optional = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "DATAPUBLICACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPublicacao;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    
    @OneToMany(mappedBy = "postCurtir")
    private List<Curtir> curtidas;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public List<Curtir> getCurtir() {
        return curtidas;
    }

    public void setCurtir(List<Curtir> curtidas) {
        this.curtidas = curtidas;
    }
}
