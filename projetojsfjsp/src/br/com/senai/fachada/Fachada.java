package br.com.senai.fachada;

import java.util.List;

import br.com.senai.controller.AlunoBC;
import br.com.senai.controller.ProjetoAcademicoBC;
import br.com.senai.controller.UsuarioBC;
import br.com.senai.model.Aluno;
import br.com.senai.model.ProjetoAcademico;
import br.com.senai.model.Usuario;

public class Fachada {

	private UsuarioBC usuarioBC;
	private ProjetoAcademicoBC projetoAcademicoBC;
	private AlunoBC alunoBC;

	public Fachada() {
		usuarioBC = new UsuarioBC();
		projetoAcademicoBC = new ProjetoAcademicoBC();
	}

	public UsuarioBC getUsuarioBC() {
		return usuarioBC;
	}

	public void setUsuarioBC(UsuarioBC usuarioBC) {
		this.usuarioBC = usuarioBC;
	}

	public void inserirUsuario(Usuario usuario) {
		getUsuarioBC().inserir(usuario);
	}

	public void alterarUsuario(Usuario usuario) {
		getUsuarioBC().alterar(usuario);
	}

	public void excluirUsuario(Usuario usuario) {
		getUsuarioBC().excluir(usuario);
	}

	public List<Usuario> listarUsuario() {
		return getUsuarioBC().listar();
	}

	//////////////////////////////////
	// Fachada para ProjetoAcademicoBC
	//////////////////////////////////

	public ProjetoAcademicoBC getProjetoAcademicoBC() {
		return projetoAcademicoBC;
	}

	public void setProjetoAcademicoBC(ProjetoAcademicoBC projetoAcademicoBC) {
		this.projetoAcademicoBC = projetoAcademicoBC;
	}

	public void inserirProjetoAcademico(ProjetoAcademico projetoAcademico) {
		getProjetoAcademicoBC().inserir(projetoAcademico);
	}

	public void alterarProjetoAcademico(ProjetoAcademico projetoAcademico) {
		getProjetoAcademicoBC().alterar(projetoAcademico);
	}

	public void excluirProjetoAcademico(ProjetoAcademico projetoAcademico) {
		getProjetoAcademicoBC().excluir(projetoAcademico);
	}

	public List<ProjetoAcademico> listarProjetoAcademico() {
		return getProjetoAcademicoBC().listar();
	}

	//////////////////////////////////
	// Fachada para AlunoBC
	//////////////////////////////////

	public AlunoBC getAlunoBC() {
		return alunoBC;
	}

	public void setAlunoBC(AlunoBC alunoBC) {
		this.alunoBC = alunoBC;
	}

	public void inserirAluno(Aluno aluno) {
		getAlunoBC().inserir(aluno);
	}

	public void alterarAluno(Aluno aluno) {
		getAlunoBC().alterar(aluno);
	}

	public void excluirAluno(Aluno aluno) {
		getAlunoBC().excluir(aluno);
	}

	public List<Aluno> listarAluno() {

		return getAlunoBC().listar();

	}

	public List<Usuario> listarUsuarioDisponivelParaAluno(Aluno aluno) {

		List<Usuario> usuariosDisponiveis = getUsuarioBC().listarDesvinculado();

		if (aluno != null && aluno.getUsuario() != null) {

			usuariosDisponiveis.add(aluno.getUsuario());

		}

		return usuariosDisponiveis;

	}

}
