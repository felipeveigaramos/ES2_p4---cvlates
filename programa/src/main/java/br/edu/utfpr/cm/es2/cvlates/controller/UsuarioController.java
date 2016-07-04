package br.edu.utfpr.cm.es2.cvlates.controller;

import java.util.ArrayList;

import br.edu.utfpr.cm.es2.cvlates.dao.UsuarioJpaDao;
import br.edu.utfpr.cm.es2.cvlates.entity.Usuario;

public class UsuarioController {
    private UsuarioJpaDao dao;

    public UsuarioController() {
        dao = new UsuarioJpaDao();
    }

    public Usuario persist(Usuario entity) {
        return dao.persist(entity);
    }

    public Usuario merge(Usuario entity) {
        return dao.merge(entity);
    }

    public void remove(Long id) {
        dao.remove(id);
        ;
    }

    public ArrayList<Usuario> finDall() {
        return (ArrayList<Usuario>) dao.finDall();
    }

    public Usuario findById(Long id) {
        return dao.findById(id);
    }

}