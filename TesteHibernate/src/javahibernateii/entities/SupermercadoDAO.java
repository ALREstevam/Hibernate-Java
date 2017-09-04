/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahibernateii.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import hibernatelocal.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author andre
 */
public class SupermercadoDAO {
    public void insert(Supermercado mercado){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction trs = null;
        
        try{
            trs = sess.beginTransaction();
            sess.saveOrUpdate(mercado);
            trs.commit();
        }
        catch(HibernateException e){
            if (trs!=null) trs.rollback();
            e.printStackTrace();
        }
        finally{
            sess.flush();
            sess.close();
            System.err.println("[SUPERMERCADO INSERIDO COM SUCESSO]");
        }
    }
    
       public void update(Supermercado mercado){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction trs = null;
        
        try{
            trs = sess.beginTransaction();
            sess.update(mercado);
            trs.commit();
            System.err.println("[SUPERMERCADO ATUALIZADO COM SUCESSO]");
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
    
    public void delete(Supermercado mercado){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction trs = null;
        
        try{
            trs = sess.beginTransaction();
            sess.delete(mercado);
            trs.commit();
            System.err.println("[SUPERMERCADO DELETADO COM SUCESSO]");
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
    
    public List<Supermercado> getAll(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        
        Query select = sess.createQuery("FROM mercado AS Supermercado");
        List<Supermercado> rsp = select.list();
        return rsp;
    }
    
    public List<Supermercado> executeQuery(String query){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        
        try{
            Query select = sess.createQuery(query);
            List<Supermercado> rsp = select.list();
            System.err.println("[CONSULTA EFETUADA COM SUCESSO]");
            return rsp;
        }catch(HibernateException e){
            e.printStackTrace();
        }
        return null;
    }
    
}
