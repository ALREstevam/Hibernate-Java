/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahibernateii;

import controllers.Controller;
import java.util.ArrayList;
import java.util.List;
import javahibernateii.entities.Supermercado;
import javahibernateii.entities.Cupom;
import javahibernateii.entities.CupomDAO;
import javahibernateii.entities.SupermercadoDAO;


/**
 *
 * @author andre
 */
public class JavaHibernateII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        testSets();
       // testRead();
        
        System.exit(0);
    }
    
    public static void testSets(){
        CupomDAO cupDao = new CupomDAO();
        SupermercadoDAO supDao = new SupermercadoDAO();
        Controller entityController = new Controller(supDao, cupDao);
        
        Cupom[] cups = new Cupom[5];
        Supermercado[] mercs = new Supermercado[3];
        
        
        mercs[0] = new Supermercado("Mercadinho Big Bom", 20);
        mercs[1] = new Supermercado("GoodBom", 7);
        mercs[2] = new Supermercado("Dia", 2);
        
        cups[0] = new Cupom("Emerson", true, mercs[0]);
        cups[1] = new Cupom("Evaristo", false, mercs[1]);
        cups[2] = new Cupom("Bianca", false, mercs[0]);
        cups[3] = new Cupom("Cráudia", true, mercs[1]);
        cups[4] = new Cupom("Vlad Myr", false, mercs[1]);
                
        
        System.out.println("\n### ADICIONANDO MERCADOS ###");
        for(Supermercado sup : mercs){
            System.out.println(sup.toPrint2());
            entityController.add(sup);
        }
        
        System.out.println("\n### ADICIONANDO CUPONS ###");
        for(Cupom cup: cups){
            System.out.println(cup.toPrint2());
            entityController.add(cup);
        }
        
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### TUDO CERTO ###");
        System.out.println("\n## CUPONS ##");
        entityController.listCupons();
        /*---------------------------------------------------------------------------*/
        System.out.println("\n## MERCADOS ##");
        entityController.listMercados();
        
        System.exit(0);
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### TUDO SETADO ###");
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### ATUALIZANDO CUPOM ###");
        System.out.println("\n## INDEX BEGIN ##");
        cups[0].setAprovado(false);
        cups[0].setNome("Emersa");
        entityController.update(cups[0]);
        
        System.out.println("\n## INDEX MIDDLE ##");
        cups[1].setNome("Evaristo Neves");
        entityController.update(cups[0]);
        
        System.out.println("\n## INDEX END ##");
        cups[4].setNome("Vlad de Myr");
        cups[4].setAprovado(true);
        entityController.update(cups[4]);
        
        entityController.listCupons();
        
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### ATUALIZANDO MERCADO ###");
        System.out.println("\n## INDEX BEGIN ##");
        mercs[0].setNomeMercado("Super Mercadinho Big Bom");
        entityController.update(mercs[0]);
        
        System.out.println("\n## INDEX MIDDLE ##");
        mercs[1].setNomeMercado("Mercado GOD BOOM");
        entityController.update(mercs[1]);
        
        System.out.println("\n## INDEX END ##");
        mercs[2].setNomeMercado("Diagh");
        entityController.update(mercs[2]);
        
        entityController.listMercados();
        
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### REMOVENDO CUPOM ###");
        entityController.remove(cups[3]);
        entityController.listCupons();
        
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### REMOVENDO MERCADO ###");
        entityController.remove(mercs[2]);
        entityController.listMercados();
        
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### LISTANDO CUPONS ###");
        entityController.setCupons((ArrayList<Cupom>) cupDao.getAll());
        entityController.listCupons();
        
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### LISTANDO MERCADOS ###");
        entityController.setMercados((ArrayList<Supermercado>) supDao.getAll());
        entityController.listMercados();
        
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### CONSULTA CUPONS ###");
        entityController.setCupons((ArrayList<Cupom>) cupDao.executeQuery("FROM cupom AS Cupom WHERE aprovado = true"));
        entityController.listCupons();
        
        /*---------------------------------------------------------------------------*/
        System.out.println("\n### CONSLULTA MERCADOS ###");
        entityController.setMercados((ArrayList<Supermercado>) supDao.executeQuery("FROM mercado AS Supermercado WHERE notaMercado > 10"));
        entityController.listMercados();
        
    }
    
    
}
