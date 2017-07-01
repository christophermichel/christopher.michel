package br.com.crescer.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;                                                   
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

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
    
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
        
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String senha;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> amigos;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> solicitacoes;

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
    
    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Usuario> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Usuario> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

}