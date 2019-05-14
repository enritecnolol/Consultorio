/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.AntecedenteP;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author flow3
 */
public class AntecedentePJpaController implements Serializable {

    public AntecedentePJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AntecedenteP antecedenteP) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente idAntecedentep = antecedenteP.getIdAntecedentep();
            if (idAntecedentep != null) {
                idAntecedentep = em.getReference(idAntecedentep.getClass(), idAntecedentep.getIdpaciente());
                antecedenteP.setIdAntecedentep(idAntecedentep);
            }
            em.persist(antecedenteP);
            if (idAntecedentep != null) {
                idAntecedentep.getAntecedentePCollection().add(antecedenteP);
                idAntecedentep = em.merge(idAntecedentep);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AntecedenteP antecedenteP) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AntecedenteP persistentAntecedenteP = em.find(AntecedenteP.class, antecedenteP.getIdAntcp());
            Paciente idAntecedentepOld = persistentAntecedenteP.getIdAntecedentep();
            Paciente idAntecedentepNew = antecedenteP.getIdAntecedentep();
            if (idAntecedentepNew != null) {
                idAntecedentepNew = em.getReference(idAntecedentepNew.getClass(), idAntecedentepNew.getIdpaciente());
                antecedenteP.setIdAntecedentep(idAntecedentepNew);
            }
            antecedenteP = em.merge(antecedenteP);
            if (idAntecedentepOld != null && !idAntecedentepOld.equals(idAntecedentepNew)) {
                idAntecedentepOld.getAntecedentePCollection().remove(antecedenteP);
                idAntecedentepOld = em.merge(idAntecedentepOld);
            }
            if (idAntecedentepNew != null && !idAntecedentepNew.equals(idAntecedentepOld)) {
                idAntecedentepNew.getAntecedentePCollection().add(antecedenteP);
                idAntecedentepNew = em.merge(idAntecedentepNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = antecedenteP.getIdAntcp();
                if (findAntecedenteP(id) == null) {
                    throw new NonexistentEntityException("The antecedenteP with id " + id + " no longer exists.");
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
            AntecedenteP antecedenteP;
            try {
                antecedenteP = em.getReference(AntecedenteP.class, id);
                antecedenteP.getIdAntcp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The antecedenteP with id " + id + " no longer exists.", enfe);
            }
            Paciente idAntecedentep = antecedenteP.getIdAntecedentep();
            if (idAntecedentep != null) {
                idAntecedentep.getAntecedentePCollection().remove(antecedenteP);
                idAntecedentep = em.merge(idAntecedentep);
            }
            em.remove(antecedenteP);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AntecedenteP> findAntecedentePEntities() {
        return findAntecedentePEntities(true, -1, -1);
    }

    public List<AntecedenteP> findAntecedentePEntities(int maxResults, int firstResult) {
        return findAntecedentePEntities(false, maxResults, firstResult);
    }

    private List<AntecedenteP> findAntecedentePEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AntecedenteP.class));
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

    public AntecedenteP findAntecedenteP(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AntecedenteP.class, id);
        } finally {
            em.close();
        }
    }

    public int getAntecedentePCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AntecedenteP> rt = cq.from(AntecedenteP.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
