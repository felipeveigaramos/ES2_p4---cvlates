package br.edu.utfpr.cm.es2.cvlates.dao;

import br.edu.utfpr.cm.es2.cvlates.entity.Usuario;

public class UsuarioJpaDao extends GenericJpaDAO<Usuario, Long> {

    public UsuarioJpaDao() {
        super(Usuario.class);
    }

}