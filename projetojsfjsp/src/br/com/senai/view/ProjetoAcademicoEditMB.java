package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DualListModel;

import br.com.senai.fachada.Fachada;
import br.com.senai.model.Aluno;
import br.com.senai.model.ProjetoAcademico;

@ManagedBean
public class ProjetoAcademicoEditMB {

	private ProjetoAcademico projetoAcademico;

	private Fachada fachada;

	private List<Aluno> alunosParaProjeto;

	public boolean isFluxoAlterar() {
		return projetoAcademico.getId() != 0;
	}

	@PostConstruct
	private void init() {
		projetoAcademico = new ProjetoAcademico();
	}

	public DualListModel<Aluno> potenciaisAlunos() {

		alunosParaProjeto = new ArrayList<Aluno>();

		return new DualListModel<Aluno>(getFachada().listarAluno(), alunosParaProjeto);

	}

	public void preAlterar(ProjetoAcademico projetoAcademico) {

		setProjetoAcademico(projetoAcademico);

	}

	public String salvar() {

		projetoAcademico.setAlunos(alunosParaProjeto);

		if (isFluxoAlterar()) {
			getFachada().alterarProjetoAcademico(projetoAcademico);
		} else {
			getFachada().inserirProjetoAcademico(projetoAcademico);
		}

		return "success";

	}

	public ProjetoAcademico getProjetoAcademico() {
		return projetoAcademico;
	}

	public void setProjetoAcademico(ProjetoAcademico projetoAcademico) {
		this.projetoAcademico = projetoAcademico;
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
