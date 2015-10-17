package br.com.senai.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ProjetoAcademico {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = true)
	private String orientador;

	@Column(nullable = true)
	private int quantMaxAluno;

	@Transient
	private List<Aluno> alunos;

	@Column(nullable = true)
	private Date dataInicio;

	@Column(nullable = true)
	private Date dataFim;

	public ProjetoAcademico() {
		// TODO Auto-generated constructor stub
	}

	public ProjetoAcademico(int id, String titulo, String orientador, int quantMaxAluno, List<Aluno> alunos,
			Date dataInicio, Date dataFim) {
		this.id = id;
		this.titulo = titulo;
		this.orientador = orientador;
		this.quantMaxAluno = quantMaxAluno;
		this.alunos = alunos;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public int getQuantMaxAluno() {
		return quantMaxAluno;
	}

	public void setQuantMaxAluno(int quantMaxAluno) {
		this.quantMaxAluno = quantMaxAluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
