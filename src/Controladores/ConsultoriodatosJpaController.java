/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Consultoriodatos;
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
 * @author flow3
 */
public class ConsultoriodatosJpaController implements Serializable {

    public ConsultoriodatosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consultoriodatos consultoriodatos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(consultoriodatos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consultoriodatos consultoriodatos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            consultoriodatos = em.merge(consultoriodatos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = consultoriodatos.getIdConsultoriodatos();
                if (findConsultoriodatos(id) == null) {
                    throw new NonexistentEntityException("The consultoriodatos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultoriodatos consultoriodatos;
            try {
                consultoriodatos = em.getReference(Consultoriodatos.class, id);
                consultoriodatos.getIdConsultoriodatos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consultoriodatos with id " + id + " no longer exists.", enfe);
            }
            em.remove(consultoriodatos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consultoriodatos> findConsultoriodatosEntities() {
        return findConsultoriodatosEntities(true, -1, -1);
    }

    public List<Consultoriodatos> findConsultoriodatosEntities(int maxResults, int firstResult) {
        return findConsultoriodatosEntities(false, maxResults, firstResult);
    }

    private List<Consultoriodatos> findConsultoriodatosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consultoriodatos.class));
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

    public Consultoriodatos findConsultoriodatos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consultoriodatos.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultoriodatosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consultoriodatos> rt = cq.from(Consultoriodatos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
