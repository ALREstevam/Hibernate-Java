/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatelocal;

import hibernatelocal.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javahibernateii.entities.Supermercado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author andre
 */
public class SupermercadoJpaController implements Serializable {

    public SupermercadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Supermercado supermercado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(supermercado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Supermercado supermercado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            supermercado = em.merge(supermercado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = supermercado.getId();
                if (findSupermercado(id) == null) {
                    throw new NonexistentEntityException("The supermercado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supermercado supermercado;
            try {
                supermercado = em.getReference(Supermercado.class, id);
                supermercado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The supermercado with id " + id + " no longer exists.", enfe);
            }
            em.remove(supermercado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Supermercado> findSupermercadoEntities() {
        return findSupermercadoEntities(true, -1, -1);
    }

    public List<Supermercado> findSupermercadoEntities(int maxResults, int firstResult) {
        return findSupermercadoEntities(false, maxResults, firstResult);
    }

    private List<Supermercado> findSupermercadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Supermercado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Supermercado findSupermercado(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Supermercado.class, id);
        } finally {
            em.close();
        }
    }

    public int getSupermercadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Supermercado> rt = cq.from(Supermercado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
