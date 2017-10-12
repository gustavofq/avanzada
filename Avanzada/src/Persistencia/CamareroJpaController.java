/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Camarero;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Facu
 */
public class CamareroJpaController implements Serializable {

    public CamareroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CamareroJpaController() {
        emf = Persistence.createEntityManagerFactory("AvanzadaPU");
    } 
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Camarero camarero) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(camarero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Camarero camarero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            camarero = em.merge(camarero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = camarero.getDni();
                if (findCamarero(id) == null) {
                    throw new NonexistentEntityException("The camarero with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Camarero camarero;
            try {
                camarero = em.getReference(Camarero.class, id);
                camarero.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The camarero with id " + id + " no longer exists.", enfe);
            }
            em.remove(camarero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Camarero> findCamareroEntities() {
        return findCamareroEntities(true, -1, -1);
    }

    public List<Camarero> findCamareroEntities(int maxResults, int firstResult) {
        return findCamareroEntities(false, maxResults, firstResult);
    }

    private List<Camarero> findCamareroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Camarero.class));
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

    public Camarero findCamarero(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Camarero.class, id);
        } finally {
            em.close();
        }
    }

    public int getCamareroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Camarero> rt = cq.from(Camarero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
