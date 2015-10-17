package br.com.senai.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.senai.fachada.Fachada;
import br.com.senai.model.ProjetoAcademico;

@ManagedBean
public class ProjetoAcademicoListMB {

	private List<ProjetoAcademico> listaProjetoAcademico;

	private ProjetoAcademico selectedProject;

	private Fachada fachada;

	@PostConstruct
	private void init() {
		setListaProjetoAcademico(listarProjetoAcademico());
	}

	private List<ProjetoAcademico> listarProjetoAcademico() {
		return getFachada().listarProjetoAcademico();
	}

	public List<ProjetoAcademico> getListaProjetoAcademico() {
		return listaProjetoAcademico;
	}

	public void setListaProjetoAcademico(List<ProjetoAcademico> listaProjetoAcademico) {
		this.listaProjetoAcademico = listaProjetoAcademico;
	}

	public ProjetoAcademico getSelectedProject() {
		return selectedProject;
	}

	public void selecionarProjeto(ProjetoAcademico selectedProject) {
		this.selectedProject = selectedProject;
	}

	public void excluir(ProjetoAcademico projetoAcademico) {
		getFachada().excluirProjetoAcademico(projetoAcademico);
		setListaProjetoAcademico(listarProjetoAcademico());
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
