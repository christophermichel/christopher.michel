package br.com.crescer.aula7.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author chris
 */
@Entity
public class Video implements Serializable {
    
    @Id 
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO", allocationSize = 1)
    private Long id;
    
    @Column(name = "VALOR")
    @Basic(optional = true)
    private BigDecimal valor;
    
    @Column(name = "DURACAO")
    @Basic(optional = false)
    private String duracao;
    
    @Column(name = "NOME")
    @Basic(optional = true)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;
    
    @Column(name = "QUANTIDADE_ESTOQUE")
    @Basic(optional = true)
    private int quantidadeEstoque;
    
    @Column(name = "DATA_LANCAMENTO")
    @Basic(optional = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLancamento;
    
    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDuracao() {
        return duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
