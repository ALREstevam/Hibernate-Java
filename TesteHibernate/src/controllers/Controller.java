/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.Objects;
import javahibernateii.entities.Cupom;
import javahibernateii.entities.CupomDAO;
import javahibernateii.entities.Supermercado;
import javahibernateii.entities.SupermercadoDAO;

/**
 *
 * @author andre
 */
public class Controller {
    private ArrayList<Cupom> cupons;
    private ArrayList<Supermercado> mercados;
    private final SupermercadoDAO daoMercado;
    private final CupomDAO daoCupom;

    public Controller(SupermercadoDAO daoMercado, CupomDAO daoCupom) {
        this.daoMercado = daoMercado;
        this.daoCupom = daoCupom;
        cupons = new ArrayList<>();
        mercados = new ArrayList<>();
    }
    
    /*==============================
    ADD
    ==============================*/
    public void add(Cupom cupom){
        cupons.add(cupom);
        this.daoCupom.insert(cupom);
    }
    
    public void add(Supermercado merc){
        mercados.add(merc);
        this.daoMercado.insert(merc);
    }
    
    /*==============================
    REMOVE
    ==============================*/
    public void remove(Cupom cupom){
        cupons.remove(cupom);
        this.daoCupom.delete(cupom);
    }
    
    public void remove(Supermercado merc){
        mercados.remove(merc);
        this.daoMercado.delete(merc);
    }
    
    /*==============================
    UPDATE
    ==============================*/
    public boolean update(Cupom cup){
        for(Cupom elem : this.cupons){
            if(Objects.equals(elem.getId(), cup.getId())){
                int index =  cupons.indexOf(elem);
                cupons.set(index, cup);
                this.daoCupom.update(cup);
                return true;
            }
        }
        return false;
    }
    
    public boolean update(Supermercado sup){
        int index = 0;
        for(Supermercado iterelem : this.mercados){
            if(iterelem.getId() == sup.getId()){
                this.mercados.set(index, sup);
                this.daoMercado.update(iterelem);
                return true;
            }
            index++;
        }
        return false;
    }

    /*==============================
    GETTERS AND SETTERS
    ==============================*/
    public ArrayList<Cupom> getCupons() {
        return cupons;
    }

    public ArrayList<Supermercado> getMercados() {
        return mercados;
    }

    public void setCupons(ArrayList<Cupom> cupons) {
        this.cupons = cupons;
    }

    public void setMercados(ArrayList<Supermercado> mercados) {
        this.mercados = mercados;
    }
    
    /*==============================
    GET BY ID
    ==============================*/
    public Cupom getCupomById(long id){
        for(Cupom elem : this.cupons){
            if(elem.getId() == id){
                return elem;
            }
        }
        return null;
    }
    
    public Supermercado getSupermercadoById(long id){
        for(Supermercado elem : this.mercados){
            if(elem.getId() == id){
                return elem;
            }
        }
        return null;
    }
    
    /*==============================
    LIST
    ==============================*/
    public void listCupons(){
        for(Cupom elem : this.cupons){
            System.out.println(elem.toPrint2());
        }
    }
    
    public void listMercados(){
        for(Supermercado elem : this.mercados){
            System.out.println(elem.toPrint2());
        }
    }
    
    
    
}
