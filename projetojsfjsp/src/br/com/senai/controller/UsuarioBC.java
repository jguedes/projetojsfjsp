package br.com.senai.controller;

import java.util.List;

import br.com.senai.model.Usuario;
import br.com.senai.model.repository.UsuarioDAO;

public class UsuarioBC {

	private UsuarioDAO dao;

	public void inserir(Usuario usuario) {
		getDao().inserir(usuario);
	}

	public void alterar(Usuario usuario) {
		getDao().alterar(usuario);
	}

	public void excluir(Usuario usuario) {
		getDao().excluir(usuario.getId());
	}

	public List<Usuario> listar() {
		return getDao().listarUsuario();
	}

	public List<Usuario> listarDesvinculado() {
		return getDao().listarUsuarioDesvinculado();
	}

	public UsuarioDAO getDao() {
		if (dao == null) {
			dao = new UsuarioDAO();
		}
		return dao;
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

}
