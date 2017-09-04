/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahibernateii.entities;

import hibernatelocal.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author andre
 */
public class CupomDAO{
    public void insert(Cupom cupom){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction trs = null;
        
        try{
            trs = sess.beginTransaction();
            sess.saveOrUpdate(cupom);
            trs.commit();
            System.err.println("[CUPOM INSERIDO COM SUCESSO]");
        }
        catch(HibernateException e){
            if (trs!=null) trs.rollback();
            e.printStackTrace();
        }
        finally{
            sess.flush();
            sess.close();
        }
    }
    
    public void update(Cupom cupom){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction trs = null;
        
        try{
            trs = sess.beginTransaction();
            sess.update(cupom);
            trs.commit();
            System.err.println("[CUPOM ATUALIZADO COM SUCESSO]");
        }
        catch(HibernateException e){
            if (trs!=null) trs.rollback();
            e.printStackTrace();
        }
        finally{
            sess.flush();
            sess.close();
        }
    }
    
    public void delete(Cupom cupom){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction trs = null;
        
        try{
            trs = sess.beginTransaction();
            sess.delete(cupom);
            trs.commit();
            System.err.println("[CUPOM DELETADO COM SUCESSO]");
        }
        catch(HibernateException e){
            if (trs!=null) trs.rollback();
            e.printStackTrace();
        }
        finally{
            sess.flush();
            sess.close();
        }
    }
    
    public List<Cupom> getAll(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        
        Query select = sess.createQuery("FROM cupom AS Cupom");
        //Query setResultTransformer = select.setResultTransformer(Transformers.aliasToBean(Cupom.class));
        List<Cupom> rsp = select.list();
        return rsp;
    }
    
    public List<Cupom> executeQuery(String query){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        
        try{
            Query select = sess.createQuery(query);
            List<Cupom> rsp = select.list();
            System.err.println("[CONSULTA EFETUADA COM SUCESSO]");
            return rsp;
        }catch(HibernateException e){
            e.printStackTrace();
        }
        return null;
    }

}




