/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.AntecedenteP;
import java.util.ArrayList;
import java.util.Collection;
import Entidades.Citas;
import Entidades.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author flow3
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        if (paciente.getAntecedentePCollection() == null) {
            paciente.setAntecedentePCollection(new ArrayList<AntecedenteP>());
        }
        if (paciente.getCitasCollection() == null) {
            paciente.setCitasCollection(new ArrayList<Citas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<AntecedenteP> attachedAntecedentePCollection = new ArrayList<AntecedenteP>();
            for (AntecedenteP antecedentePCollectionAntecedentePToAttach : paciente.getAntecedentePCollection()) {
                antecedentePCollectionAntecedentePToAttach = em.getReference(antecedentePCollectionAntecedentePToAttach.getClass(), antecedentePCollectionAntecedentePToAttach.getIdAntcp());
                attachedAntecedentePCollection.add(antecedentePCollectionAntecedentePToAttach);
            }
            paciente.setAntecedentePCollection(attachedAntecedentePCollection);
            Collection<Citas> attachedCitasCollection = new ArrayList<Citas>();
            for (Citas citasCollectionCitasToAttach : paciente.getCitasCollection()) {
                citasCollectionCitasToAttach = em.getReference(citasCollectionCitasToAttach.getClass(), citasCollectionCitasToAttach.getIdCitas());
                attachedCitasCollection.add(citasCollectionCitasToAttach);
            }
            paciente.setCitasCollection(attachedCitasCollection);
            em.persist(paciente);
            for (AntecedenteP antecedentePCollectionAntecedenteP : paciente.getAntecedentePCollection()) {
                Paciente oldIdAntecedentepOfAntecedentePCollectionAntecedenteP = antecedentePCollectionAntecedenteP.getIdAntecedentep();
                antecedentePCollectionAntecedenteP.setIdAntecedentep(paciente);
                antecedentePCollectionAntecedenteP = em.merge(antecedentePCollectionAntecedenteP);
                if (oldIdAntecedentepOfAntecedentePCollectionAntecedenteP != null) {
                    oldIdAntecedentepOfAntecedentePCollectionAntecedenteP.getAntecedentePCollection().remove(antecedentePCollectionAntecedenteP);
                    oldIdAntecedentepOfAntecedentePCollectionAntecedenteP = em.merge(oldIdAntecedentepOfAntecedentePCollectionAntecedenteP);
                }
            }
            for (Citas citasCollectionCitas : paciente.getCitasCollection()) {
                Paciente oldIdpacientepOfCitasCollectionCitas = citasCollectionCitas.getIdpacientep();
                citasCollectionCitas.setIdpacientep(paciente);
                citasCollectionCitas = em.merge(citasCollectionCitas);
                if (oldIdpacientepOfCitasCollectionCitas != null) {
                    oldIdpacientepOfCitasCollectionCitas.getCitasCollection().remove(citasCollectionCitas);
                    oldIdpacientepOfCitasCollectionCitas = em.merge(oldIdpacientepOfCitasCollectionCitas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getIdpaciente());
            Collection<AntecedenteP> antecedentePCollectionOld = persistentPaciente.getAntecedentePCollection();
            Collection<AntecedenteP> antecedentePCollectionNew = paciente.getAntecedentePCollection();
            Collection<Citas> citasCollectionOld = persistentPaciente.getCitasCollection();
            Collection<Citas> citasCollectionNew = paciente.getCitasCollection();
            List<String> illegalOrphanMessages = null;
            for (Citas citasCollectionOldCitas : citasCollectionOld) {
                if (!citasCollectionNew.contains(citasCollectionOldCitas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Citas " + citasCollectionOldCitas + " since its idpacientep field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<AntecedenteP> attachedAntecedentePCollectionNew = new ArrayList<AntecedenteP>();
            for (AntecedenteP antecedentePCollectionNewAntecedentePToAttach : antecedentePCollectionNew) {
                antecedentePCollectionNewAntecedentePToAttach = em.getReference(antecedentePCollectionNewAntecedentePToAttach.getClass(), antecedentePCollectionNewAntecedentePToAttach.getIdAntcp());
                attachedAntecedentePCollectionNew.add(antecedentePCollectionNewAntecedentePToAttach);
            }
            antecedentePCollectionNew = attachedAntecedentePCollectionNew;
            paciente.setAntecedentePCollection(antecedentePCollectionNew);
            Collection<Citas> attachedCitasCollectionNew = new ArrayList<Citas>();
            for (Citas citasCollectionNewCitasToAttach : citasCollectionNew) {
                citasCollectionNewCitasToAttach = em.getReference(citasCollectionNewCitasToAttach.getClass(), citasCollectionNewCitasToAttach.getIdCitas());
                attachedCitasCollectionNew.add(citasCollectionNewCitasToAttach);
            }
            citasCollectionNew = attachedCitasCollectionNew;
            paciente.setCitasCollection(citasCollectionNew);
            paciente = em.merge(paciente);
            for (AntecedenteP antecedentePCollectionOldAntecedenteP : antecedentePCollectionOld) {
                if (!antecedentePCollectionNew.contains(antecedentePCollectionOldAntecedenteP)) {
                    antecedentePCollectionOldAntecedenteP.setIdAntecedentep(null);
                    antecedentePCollectionOldAntecedenteP = em.merge(antecedentePCollectionOldAntecedenteP);
                }
            }
            for (AntecedenteP antecedentePCollectionNewAntecedenteP : antecedentePCollectionNew) {
                if (!antecedentePCollectionOld.contains(antecedentePCollectionNewAntecedenteP)) {
                    Paciente oldIdAntecedentepOfAntecedentePCollectionNewAntecedenteP = antecedentePCollectionNewAntecedenteP.getIdAntecedentep();
                    antecedentePCollectionNewAntecedenteP.setIdAntecedentep(paciente);
                    antecedentePCollectionNewAntecedenteP = em.merge(antecedentePCollectionNewAntecedenteP);
                    if (oldIdAntecedentepOfAntecedentePCollectionNewAntecedenteP != null && !oldIdAntecedentepOfAntecedentePCollectionNewAntecedenteP.equals(paciente)) {
                        oldIdAntecedentepOfAntecedentePCollectionNewAntecedenteP.getAntecedentePCollection().remove(antecedentePCollectionNewAntecedenteP);
                        oldIdAntecedentepOfAntecedentePCollectionNewAntecedenteP = em.merge(oldIdAntecedentepOfAntecedentePCollectionNewAntecedenteP);
                    }
                }
            }
            for (Citas citasCollectionNewCitas : citasCollectionNew) {
                if (!citasCollectionOld.contains(citasCollectionNewCitas)) {
                    Paciente oldIdpacientepOfCitasCollectionNewCitas = citasCollectionNewCitas.getIdpacientep();
                    citasCollectionNewCitas.setIdpacientep(paciente);
                    citasCollectionNewCitas = em.merge(citasCollectionNewCitas);
                    if (oldIdpacientepOfCitasCollectionNewCitas != null && !oldIdpacientepOfCitasCollectionNewCitas.equals(paciente)) {
                        oldIdpacientepOfCitasCollectionNewCitas.getCitasCollection().remove(citasCollectionNewCitas);
                        oldIdpacientepOfCitasCollectionNewCitas = em.merge(oldIdpacientepOfCitasCollectionNewCitas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getIdpaciente();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getIdpaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Citas> citasCollectionOrphanCheck = paciente.getCitasCollection();
            for (Citas citasCollectionOrphanCheckCitas : citasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Citas " + citasCollectionOrphanCheckCitas + " in its citasCollection field has a non-nullable idpacientep field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<AntecedenteP> antecedentePCollection = paciente.getAntecedentePCollection();
            for (AntecedenteP antecedentePCollectionAntecedenteP : antecedentePCollection) {
                antecedentePCollectionAntecedenteP.setIdAntecedentep(null);
                antecedentePCollectionAntecedenteP = em.merge(antecedentePCollectionAntecedenteP);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void setModel(DefaultTableModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
