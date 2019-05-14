/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Login;
import Entidades.RegistroUsuarios;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author flow3
 */
public class RegistroUsuariosJpaController implements Serializable {

    public RegistroUsuariosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RegistroUsuarios registroUsuarios) {
        if (registroUsuarios.getLoginCollection() == null) {
            registroUsuarios.setLoginCollection(new ArrayList<Login>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Login> attachedLoginCollection = new ArrayList<Login>();
            for (Login loginCollectionLoginToAttach : registroUsuarios.getLoginCollection()) {
                loginCollectionLoginToAttach = em.getReference(loginCollectionLoginToAttach.getClass(), loginCollectionLoginToAttach.getIdlogin());
                attachedLoginCollection.add(loginCollectionLoginToAttach);
            }
            registroUsuarios.setLoginCollection(attachedLoginCollection);
            em.persist(registroUsuarios);
            for (Login loginCollectionLogin : registroUsuarios.getLoginCollection()) {
                RegistroUsuarios oldIdrOfLoginCollectionLogin = loginCollectionLogin.getIdr();
                loginCollectionLogin.setIdr(registroUsuarios);
                loginCollectionLogin = em.merge(loginCollectionLogin);
                if (oldIdrOfLoginCollectionLogin != null) {
                    oldIdrOfLoginCollectionLogin.getLoginCollection().remove(loginCollectionLogin);
                    oldIdrOfLoginCollectionLogin = em.merge(oldIdrOfLoginCollectionLogin);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RegistroUsuarios registroUsuarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RegistroUsuarios persistentRegistroUsuarios = em.find(RegistroUsuarios.class, registroUsuarios.getIdRegistrousuarios());
            Collection<Login> loginCollectionOld = persistentRegistroUsuarios.getLoginCollection();
            Collection<Login> loginCollectionNew = registroUsuarios.getLoginCollection();
            Collection<Login> attachedLoginCollectionNew = new ArrayList<Login>();
            for (Login loginCollectionNewLoginToAttach : loginCollectionNew) {
                loginCollectionNewLoginToAttach = em.getReference(loginCollectionNewLoginToAttach.getClass(), loginCollectionNewLoginToAttach.getIdlogin());
                attachedLoginCollectionNew.add(loginCollectionNewLoginToAttach);
            }
            loginCollectionNew = attachedLoginCollectionNew;
            registroUsuarios.setLoginCollection(loginCollectionNew);
            registroUsuarios = em.merge(registroUsuarios);
            for (Login loginCollectionOldLogin : loginCollectionOld) {
                if (!loginCollectionNew.contains(loginCollectionOldLogin)) {
                    loginCollectionOldLogin.setIdr(null);
                    loginCollectionOldLogin = em.merge(loginCollectionOldLogin);
                }
            }
            for (Login loginCollectionNewLogin : loginCollectionNew) {
                if (!loginCollectionOld.contains(loginCollectionNewLogin)) {
                    RegistroUsuarios oldIdrOfLoginCollectionNewLogin = loginCollectionNewLogin.getIdr();
                    loginCollectionNewLogin.setIdr(registroUsuarios);
                    loginCollectionNewLogin = em.merge(loginCollectionNewLogin);
                    if (oldIdrOfLoginCollectionNewLogin != null && !oldIdrOfLoginCollectionNewLogin.equals(registroUsuarios)) {
                        oldIdrOfLoginCollectionNewLogin.getLoginCollection().remove(loginCollectionNewLogin);
                        oldIdrOfLoginCollectionNewLogin = em.merge(oldIdrOfLoginCollectionNewLogin);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = registroUsuarios.getIdRegistrousuarios();
                if (findRegistroUsuarios(id) == null) {
                    throw new NonexistentEntityException("The registroUsuarios with id " + id + " no longer exists.");
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
            RegistroUsuarios registroUsuarios;
            try {
                registroUsuarios = em.getReference(RegistroUsuarios.class, id);
                registroUsuarios.getIdRegistrousuarios();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registroUsuarios with id " + id + " no longer exists.", enfe);
            }
            Collection<Login> loginCollection = registroUsuarios.getLoginCollection();
            for (Login loginCollectionLogin : loginCollection) {
                loginCollectionLogin.setIdr(null);
                loginCollectionLogin = em.merge(loginCollectionLogin);
            }
            em.remove(registroUsuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RegistroUsuarios> findRegistroUsuariosEntities() {
        return findRegistroUsuariosEntities(true, -1, -1);
    }

    public List<RegistroUsuarios> findRegistroUsuariosEntities(int maxResults, int firstResult) {
        return findRegistroUsuariosEntities(false, maxResults, firstResult);
    }

    private List<RegistroUsuarios> findRegistroUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RegistroUsuarios.class));
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

    public RegistroUsuarios findRegistroUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RegistroUsuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistroUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RegistroUsuarios> rt = cq.from(RegistroUsuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
