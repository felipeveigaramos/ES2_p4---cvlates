package br.edu.utfpr.cm.es2.cvlates.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class GenericJpaDAO<BASE extends EntidadeBase> {

	public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cvlattes");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    public void persist(BASE objeto) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("BodyFitnessPU");
        //EntityManager em = emf.createEntityManager();
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            if(objeto.getId() == null) {
                em.persist(objeto);
            }
            else {
                if(!em.contains(objeto)) {
                    if(em.find(objeto.getClass(), objeto.getId()) == null) {
                        throw new Exception("Erro ao atualizar!");
                    }
                }
                em.merge(objeto);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void delete(Class<BASE> clazz, Long id) throws Exception {
        EntityManager em = getEntityManager();
        BASE objeto = em.find(clazz, id);
        try {
            if(objeto == null) {
                throw new Exception("Erro na delecao! Objeto nao encontrado");
            }
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
        }
        finally{
            em.close();
        }
    }
    
    public BASE searchById(Class<BASE> clazz, Long id) {
        EntityManager em = getEntityManager();
        BASE objeto = null;
        try {
            objeto = em.find(clazz, id);
        }
        finally {
            em.close();
        }
        return objeto;
    }

}
