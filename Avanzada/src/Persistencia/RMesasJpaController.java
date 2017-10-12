/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.RMesas;
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
public class RMesasJpaController implements Serializable {

    public RMesasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public RMesasJpaController() {
        emf = Persistence.createEntityManagerFactory("AvanzadaPU");
    }
    
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RMesas RMesas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(RMesas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RMesas RMesas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RMesas = em.merge(RMesas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = RMesas.getId();
                if (findRMesas(id) == null) {
                    throw new NonexistentEntityException("The rMesas with id " + id + " no longer exists.");
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
            RMesas RMesas;
            try {
                RMesas = em.getReference(RMesas.class, id);
                RMesas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The RMesas with id " + id + " no longer exists.", enfe);
            }
            em.remove(RMesas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RMesas> findRMesasEntities() {
        return findRMesasEntities(true, -1, -1);
    }

    public List<RMesas> findRMesasEntities(int maxResults, int firstResult) {
        return findRMesasEntities(false, maxResults, firstResult);
    }

    private List<RMesas> findRMesasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RMesas.class));
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

    public RMesas findRMesas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RMesas.class, id);
        } finally {
            em.close();
        }
    }

    public int getRMesasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RMesas> rt = cq.from(RMesas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
