package br.com.crescer.aula04;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author chris
 */

@Entity
public class Locacao implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO")
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "VALOR_TOTAL")
    @Basic(optional = true)
    private BigDecimal valorTotal;
    
    @Column(name = "DATA_DEVOLUCAO")
    @Basic(optional = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDevolucao;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_VIDEO")
    private Video video;

    public Long getId() {
        return id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Video getVideo() {
        return video;
    }
    
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}