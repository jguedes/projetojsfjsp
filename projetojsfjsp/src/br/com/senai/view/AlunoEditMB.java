package br.com.senai.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.senai.fachada.Fachada;
import br.com.senai.model.Aluno;
import br.com.senai.model.Usuario;

@ManagedBean
public class AlunoEditMB {

	private Aluno aluno;

	private Fachada fachada;

	public boolean isFluxoAlterar() {
		return aluno.getId() != 0;
	}

	@PostConstruct
	private void init() {
		aluno = new Aluno();
	}

	public List<Usuario> usuariosDisponiveis() {

		return getFachada().listarUsuarioDisponivelParaAluno(aluno);

	}

	public void preAlterar(Aluno aluno) {
		setAluno(aluno);
	}

	public String salvar() {
		if (isFluxoAlterar()) {
			getFachada().alterarAluno(aluno);
		} else {
			getFachada().inserirAluno(aluno);
		}
		return "success";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
