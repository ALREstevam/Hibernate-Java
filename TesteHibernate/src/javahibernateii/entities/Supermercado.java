/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahibernateii.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author andre
 */
@Entity(name = "mercado")
public class Supermercado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "nome_mercado")
    private String nomeMercado;
    
    @Column(name = "nota_mercado")
    private int notaMercado;

    public Supermercado() {
    }

    public Supermercado(String nomeMercado, int notaMercado) {
        this.nomeMercado = nomeMercado;
        this.notaMercado = notaMercado;
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
        if (!(object instanceof Supermercado)) {
            return false;
        }
        Supermercado other = (Supermercado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javahibernateii.entities.Supermercado[ id=" + id + " ]";
    }

    public String getNomeMercado() {
        return nomeMercado;
    }

    public void setNomeMercado(String nomeMercado) {
        this.nomeMercado = nomeMercado;
    }

    public int getNotaMercado() {
        return notaMercado;
    }

    public void setNotaMercado(int notaMercado) {
        this.notaMercado = notaMercado;
    }
    
    public String toPrint(){
        String rsp = ""
                + "{\n"
                + "\tSupermercado: " + this.id + "{\n" 
                + "\t\tnome: \"" + this.nomeMercado +"\",\n" 
                + "\t\tnota: "+ this.notaMercado +",\n"
                + "\t}\n"
                + "}\n";
                
        return rsp;
    }
    
    public String toPrint2(){
        return "[SUPERMERCADO]{id: "+this.id+" | nome: "+this.nomeMercado+" | nota: "+this.notaMercado+ "};";
    }    
}
