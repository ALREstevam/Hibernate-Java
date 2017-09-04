/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahibernateii.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andre
 */
@Entity(name = "cupom")
public class Cupom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "pessoa_nome")
    private String nome;
    
    @Column(name = "pessoa_aprovada")
    private boolean aprovado;
    
    @ManyToOne
    @JoinColumn(name = "id_mercado", foreignKey = @ForeignKey(name = "FK_MERCADO"))
    private Supermercado ptoVenda;

    
    /////////////////////////////////////
    public Cupom() {
        
    }
    
    /*
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nasc")
    private Calendar dataNasc;
    */

    public Cupom(String nome, boolean aprovado, Supermercado ptoVenda) {
        this.nome = nome;
        this.aprovado = aprovado;
        this.ptoVenda = ptoVenda;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cupom)) {
            return false;
        }
        Cupom other = (Cupom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Supermercado getPtoVenda() {
        return ptoVenda;
    }

    public void setPtoVenda(Supermercado ptoVenda) {
        this.ptoVenda = ptoVenda;
    }

    @Override
    public String toString() {
        return "javahibernateii.entities.Cupom[ id=" + id + " ]";
    }
    
    public String toPrint(){
        String rsp = "{\n"
                + "\tCupom: " + this.id + " = {\n"
                + "\t\t nome: \"" + this.nome + "\",\n"
                + "\t\t aprovado: " + this.aprovado + ",\n"
                + "\t\t ptoVenda: \"" + this.ptoVenda.getNomeMercado() + "\",\n"
                + "\t}\n"
                + "}\n";
        
        return rsp;
    }
    
    public String toPrint2(){
        return "[CUPOM]{id: "+this.id+" | nome: "+this.nome+" | aprovado: "+this.aprovado+" | ptoVenda: "+this.ptoVenda.getNomeMercado()+"};";
    }

   
    
}
