package br.com.senai.controller;

import java.util.List;

import br.com.senai.model.ProjetoAcademico;
import br.com.senai.model.repository.ProjetoAcademicoDAO;

public class ProjetoAcademicoBC {

	private ProjetoAcademicoDAO dao;

	public void inserir(ProjetoAcademico projetoAcademico) {
		getDao().inserir(projetoAcademico);
	}

	public void alterar(ProjetoAcademico projetoAcademico) {
		getDao().alterar(projetoAcademico);
	}

	public void excluir(ProjetoAcademico projetoAcademico) {
		getDao().excluir(projetoAcademico.getId());
	}

	public List<ProjetoAcademico> listar() {
		return getDao().listarProjetoAcademico();
	}

	public ProjetoAcademicoDAO getDao() {
		if (dao == null) {
			dao = new ProjetoAcademicoDAO();
		}
		return dao;
	}

	public void setDao(ProjetoAcademicoDAO dao) {
		this.dao = dao;
	}

}
