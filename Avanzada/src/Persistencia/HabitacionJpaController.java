/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Habitacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Tipo;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Facu
 */
public class HabitacionJpaController implements Serializable {

    public HabitacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Habitacion habitacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipo unTipo = habitacion.getUnTipo();
            if (unTipo != null) {
                unTipo = em.getReference(unTipo.getClass(), unTipo.getId());
                habitacion.setUnTipo(unTipo);
            }
            em.persist(habitacion);
            if (unTipo != null) {
                Habitacion oldUnaHabitacionOfUnTipo = unTipo.getUnaHabitacion();
                if (oldUnaHabitacionOfUnTipo != null) {
                    oldUnaHabitacionOfUnTipo.setUnTipo(null);
                    oldUnaHabitacionOfUnTipo = em.merge(oldUnaHabitacionOfUnTipo);
                }
                unTipo.setUnaHabitacion(habitacion);
                unTipo = em.merge(unTipo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Habitacion habitacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion persistentHabitacion = em.find(Habitacion.class, habitacion.getId());
            Tipo unTipoOld = persistentHabitacion.getUnTipo();
            Tipo unTipoNew = habitacion.getUnTipo();
            if (unTipoNew != null) {
                unTipoNew = em.getReference(unTipoNew.getClass(), unTipoNew.getId());
                habitacion.setUnTipo(unTipoNew);
            }
            habitacion = em.merge(habitacion);
            if (unTipoOld != null && !unTipoOld.equals(unTipoNew)) {
                unTipoOld.setUnaHabitacion(null);
                unTipoOld = em.merge(unTipoOld);
            }
            if (unTipoNew != null && !unTipoNew.equals(unTipoOld)) {
                Habitacion oldUnaHabitacionOfUnTipo = unTipoNew.getUnaHabitacion();
                if (oldUnaHabitacionOfUnTipo != null) {
                    oldUnaHabitacionOfUnTipo.setUnTipo(null);
                    oldUnaHabitacionOfUnTipo = em.merge(oldUnaHabitacionOfUnTipo);
                }
                unTipoNew.setUnaHabitacion(habitacion);
                unTipoNew = em.merge(unTipoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = habitacion.getId();
                if (findHabitacion(id) == null) {
                    throw new NonexistentEntityException("The habitacion with id " + id + " no longer exists.");
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
            Habitacion habitacion;
            try {
                habitacion = em.getReference(Habitacion.class, id);
                habitacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The habitacion with id " + id + " no longer exists.", enfe);
            }
            Tipo unTipo = habitacion.getUnTipo();
            if (unTipo != null) {
                unTipo.setUnaHabitacion(null);
                unTipo = em.merge(unTipo);
            }
            em.remove(habitacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Habitacion> findHabitacionEntities() {
        return findHabitacionEntities(true, -1, -1);
    }

    public List<Habitacion> findHabitacionEntities(int maxResults, int firstResult) {
        return findHabitacionEntities(false, maxResults, firstResult);
    }

    private List<Habitacion> findHabitacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Habitacion.class));
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

    public Habitacion findHabitacion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Habitacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getHabitacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Habitacion> rt = cq.from(Habitacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
