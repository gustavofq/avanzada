/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Habitacion;
import Logica.Tipo;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Facu
 */
public class TipoJpaController implements Serializable {

    public TipoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public TipoJpaController() {
        emf = Persistence.createEntityManagerFactory("AvanzadaPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipo tipo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion unaHabitacion = tipo.getUnaHabitacion();
            if (unaHabitacion != null) {
                unaHabitacion = em.getReference(unaHabitacion.getClass(), unaHabitacion.getId());
                tipo.setUnaHabitacion(unaHabitacion);
            }
            em.persist(tipo);
            if (unaHabitacion != null) {
                Tipo oldUnTipoOfUnaHabitacion = unaHabitacion.getUnTipo();
                if (oldUnTipoOfUnaHabitacion != null) {
                    oldUnTipoOfUnaHabitacion.setUnaHabitacion(null);
                    oldUnTipoOfUnaHabitacion = em.merge(oldUnTipoOfUnaHabitacion);
                }
                unaHabitacion.setUnTipo(tipo);
                unaHabitacion = em.merge(unaHabitacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipo tipo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipo persistentTipo = em.find(Tipo.class, tipo.getId());
            Habitacion unaHabitacionOld = persistentTipo.getUnaHabitacion();
            Habitacion unaHabitacionNew = tipo.getUnaHabitacion();
            if (unaHabitacionNew != null) {
                unaHabitacionNew = em.getReference(unaHabitacionNew.getClass(), unaHabitacionNew.getId());
                tipo.setUnaHabitacion(unaHabitacionNew);
            }
            tipo = em.merge(tipo);
            if (unaHabitacionOld != null && !unaHabitacionOld.equals(unaHabitacionNew)) {
                unaHabitacionOld.setUnTipo(null);
                unaHabitacionOld = em.merge(unaHabitacionOld);
            }
            if (unaHabitacionNew != null && !unaHabitacionNew.equals(unaHabitacionOld)) {
                Tipo oldUnTipoOfUnaHabitacion = unaHabitacionNew.getUnTipo();
                if (oldUnTipoOfUnaHabitacion != null) {
                    oldUnTipoOfUnaHabitacion.setUnaHabitacion(null);
                    oldUnTipoOfUnaHabitacion = em.merge(oldUnTipoOfUnaHabitacion);
                }
                unaHabitacionNew.setUnTipo(tipo);
                unaHabitacionNew = em.merge(unaHabitacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipo.getId();
                if (findTipo(id) == null) {
                    throw new NonexistentEntityException("The tipo with id " + id + " no longer exists.");
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
            Tipo tipo;
            try {
                tipo = em.getReference(Tipo.class, id);
                tipo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipo with id " + id + " no longer exists.", enfe);
            }
            Habitacion unaHabitacion = tipo.getUnaHabitacion();
            if (unaHabitacion != null) {
                unaHabitacion.setUnTipo(null);
                unaHabitacion = em.merge(unaHabitacion);
            }
            em.remove(tipo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipo> findTipoEntities() {
        return findTipoEntities(true, -1, -1);
    }

    public List<Tipo> findTipoEntities(int maxResults, int firstResult) {
        return findTipoEntities(false, maxResults, firstResult);
    }

    private List<Tipo> findTipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipo.class));
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

    public Tipo findTipo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipo> rt = cq.from(Tipo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
