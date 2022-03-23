/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import datos.Clubnautico;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.exceptions.NonexistentEntityException;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ClubnauticoJpaController implements Serializable {

    public ClubnauticoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ClubnauticoJpaController() {
        emf = Persistence.createEntityManagerFactory("ClubNauticoPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Clubnautico clubnautico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clubnautico);
            em.getTransaction().commit();
            return true;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean edit(Clubnautico clubnautico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clubnautico = em.merge(clubnautico);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = clubnautico.getIdSocio();
                if (findClubnautico(id) == null) {
                    throw new NonexistentEntityException("The clubnautico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clubnautico clubnautico;
            try {
                clubnautico = em.getReference(Clubnautico.class, id);
                clubnautico.getIdSocio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clubnautico with id " + id + " no longer exists.", enfe);
            }
            em.remove(clubnautico);
            em.getTransaction().commit();
            return true;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clubnautico> findClubnauticoEntities() {
        return findClubnauticoEntities(true, -1, -1);
    }

    public List<Clubnautico> findClubnauticoEntities(int maxResults, int firstResult) {
        return findClubnauticoEntities(false, maxResults, firstResult);
    }

    private List<Clubnautico> findClubnauticoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clubnautico.class));
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

    public Clubnautico findClubnautico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clubnautico.class, id);
        } finally {
            em.close();
        }
    }

    public int getClubnauticoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clubnautico> rt = cq.from(Clubnautico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
