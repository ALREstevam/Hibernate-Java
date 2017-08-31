/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testehibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author andre
 */
public class DaoParticipante {
     private final List<Participante> parts;

    public DaoParticipante() {
       this.parts = new ArrayList<>();
    }
    
    public void addFilaInsertUpdate(Participante part){
        this.parts.add(part);
    }
    
    public void commitInsertUpdate(){
        //Pegando fábrica de sessão
        SessionFactory sf = HibernateUtil.getSessionFactory();
        
        //Abrir sessão
        Session sess = sf.openSession();
        
        //Iniciando transação
        Transaction trs = sess.beginTransaction();
        
        for(Participante part : this.parts){
            //Salvar ou atualizar
            sess.saveOrUpdate(part);
        }

        //Commitando alterações
        trs.commit();
        //Limpando memória
        sess.flush();
        //Fechando sessão
        sess.close();
        
        this.parts.clear();
    }
    
    
    
}

/*
//Criando instâncias de Participante
        List<Participante> parts = new ArrayList<>();
        
        parts.add(new Participante("Evaristo Arnado", "eva@risto.arnaldo", 5623));
        parts.add(new Participante("Yudi Tamoshoco", "yudi@sbt.bol.br", 40028922));
        parts.add(new Participante("Jésus Chistian", "default@www.com", 777));
        
        //Pegando fábrica de sessão
        SessionFactory sf = HibernateUtil.getSessionFactory();
        
        //Abrir sessão
        Session sess = sf.openSession();
        
        //Iniciando transação
        Transaction trs = sess.beginTransaction();
        
        for(Participante part : parts){
            //Salvar ou atualizar
            sess.saveOrUpdate(part);
        }

        //Commitando alterações
        trs.commit();
        //Limpando memória
        sess.flush();
        //Fechando sessão
        sess.close();
        //Saindo do programa
        System.exit(0);
*/
