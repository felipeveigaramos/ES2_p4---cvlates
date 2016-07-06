package br.edu.utfpr.cm.es2.cvlates.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.cm.es2.cvlates.dao.UsuarioJpaDao;
import br.edu.utfpr.cm.es2.cvlates.entity.Usuario;

public class UsuarioController {
	private UsuarioJpaDao dao;

	public UsuarioController() {
		dao = new UsuarioJpaDao();
	}

	public void persist(Usuario entity) {
		dao.persist(entity);
	}

	public void merge(Usuario entity) {
		dao.persist(entity);
	}

	public void remove(Long id) throws Exception {

		dao.delete(Usuario.class, id);

	}

	public List<Usuario> finDall() {
		return  dao.buscaTodos();
	}

	public Usuario findById(Long id) {
		return dao.findById(id);
	}

}
