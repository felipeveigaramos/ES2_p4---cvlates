package br.edu.utfpr.cm.es2.cvlates.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.utfpr.cm.es2.cvlates.entity.Usuario;

public class UsuarioJpaDao extends GenericJpaDAO<Usuario> {

	@SuppressWarnings("unchecked")
	public List<Usuario> buscaTodos() {
		EntityManager em = getEntityManager();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Query q = em.createNamedQuery("Usuario.buscaTodos");
			usuarios = q.getResultList();
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
			usuarios = new ArrayList<>();
		} finally {
			em.close();
		}
		return usuarios;
	}
	
	public Usuario findById(Long id) {
		EntityManager em = getEntityManager();
		Usuario u = new Usuario();
		try {
			Query q = em.createNamedQuery("Usuario.buscaPorId");
			q.setParameter("id", id);
			u = (Usuario)q.getSingleResult();
		} catch(Exception e) {
			u = null;
			System.out.println("Erro: " + e.getMessage());
		} finally {
			em.close();
		}
		return u;
	}

}
