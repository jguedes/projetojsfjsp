package br.com.senai.controller;

import java.util.List;

import br.com.senai.model.Aluno;
import br.com.senai.model.repository.AlunoDAO;

public class AlunoBC {

	private AlunoDAO dao;

	public void inserir(Aluno aluno) {
		getDao().inserir(aluno);
	}

	public void alterar(Aluno aluno) {
		getDao().alterar(aluno);
	}

	public void excluir(Aluno aluno) {
		getDao().excluir(aluno.getId());
	}

	public List<Aluno> listar() {
		return getDao().listarAluno();
	}

	public AlunoDAO getDao() {
		if (dao == null) {
			dao = new AlunoDAO();
		}
		return dao;
	}

	public void setDao(AlunoDAO dao) {
		this.dao = dao;
	}

}
