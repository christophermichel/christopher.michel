package br.com.crescer.social.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;                                                   
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author chris
 */

@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Basic(optional = true)
    @Column(name = "ID")
    private Long id;
    
    @Email
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
        
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String senha;
    
    @Basic(optional = true)
    @Column(name = "urlFoto")
    private String urlFoto;
    
    @Basic(optional = true)
    @Column(name = "sexo")
    private String sexo;
    
    @Basic(optional = true)
    @Column(name = "instrumento_musical")
    private String instrumentoMusical;
    
    @Basic(optional = true)
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "data_nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> amigos;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> solicitacoes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "idUsuario")
    private List<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Set<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(Set<Usuario> amigos) {
        this.amigos = amigos;
    }

    public Set<Usuario> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(Set<Usuario> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getInstrumentoMusical() {
        return instrumentoMusical;
    }

    public void setInstrumentoMusical(String instrumentoMusical) {
        this.instrumentoMusical = instrumentoMusical;
    }
    
    
}