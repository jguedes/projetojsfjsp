package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DualListModel;

import br.com.senai.fachada.Fachada;
import br.com.senai.model.Aluno;

@ManagedBean
public class AlunoListMB {

	private List<Aluno> listaAluno;

	private List<Aluno> targetListaAluno;

	private Fachada fachada;

	@PostConstruct
	private void init() {
		setListaAluno(listarAluno());
	}

	public DualListModel<Aluno> listModelAluno() {

		targetListaAluno = new ArrayList<Aluno>();

		return new DualListModel<Aluno>(listaAluno, targetListaAluno);

	}

	private List<Aluno> listarAluno() {
		return getFachada().listarAluno();
	}

	public List<Aluno> getListaAluno() {
		return listaAluno;
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}

	public void excluir(Aluno aluno) {
		getFachada().excluirAluno(aluno);
		setListaAluno(listarAluno());
	}

	public Fachada getFachada() {
		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

}
