package br.com.crescer.aula04;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author chris
 */
@Entity
public class Funcionario implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(name = "SEQ_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    @Basic(optional = false)
    private String nome;

    @Column(name = "BAIRRO")
    @Basic(optional = true)
    private String bairro;
    
    @Column(name = "CIDADE")
    @Basic(optional = true)
    private String cidade;
    
    @Column(name = "NUMERO_CASA")
    @Basic(optional = true)
    private String numeroCasa;
    
    @Column(name = "RUA")
    @Basic(optional = true)
    private String rua;
    
    @Column(name = "RG")
    @Basic(optional = false)
    private String rg;
    
    @Column(name = "EMAIL")
    @Basic(optional = true)
    private String email;
    
    @Column(name = "TELEFONE")
    @Basic(optional = true)
    private String telefone;
    
    @Column(name = "CELULAR")
    @Basic(optional = true)
    private String celular;
    
    @Column(name = "SALARIO")
    @Basic(optional = true)
    private BigDecimal salario;
    
    @Column(name = "FUNCAO")
    @Basic(optional = true)
    private String funcao;
    
    @Column(name = "CPF")
    @Basic(optional = true)
    private String cpf;
    
    @Column(name = "NASCIMENTO")
    @Basic(optional = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;

    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public String getRua() {
        return rua;
    }

    public String getRg() {
        return rg;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }


    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
