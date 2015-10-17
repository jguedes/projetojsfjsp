package br.com.senai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@Column(name = "matricula", length = 10, nullable = false)
	private String matricula;

	@Column(name = "logradouro", length = 30, nullable = false)
	private String logradouro;

	@Column(name = "cep", length = 7, nullable = false)
	private String cep;

	@Column(name = "complemento", length = 10, nullable = false)
	private String complemento;

	@Column(name = "data_nascimento", nullable = false)
	private String dataNascimento;

	@OneToOne
	private Usuario usuario;

	public Aluno() {

	}

	public Aluno(String nome, String matricula, String logradouro, String cep, String complemento,
			String dataNascimento) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.logradouro = logradouro;
		this.cep = cep;
		this.complemento = complemento;
		this.dataNascimento = dataNascimento;
	}

	public Aluno(int id, String nome, String matricula, String logradouro, String cep, String complemento,
			String dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.logradouro = logradouro;
		this.cep = cep;
		this.complemento = complemento;
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {

		return this.nome;

	}

}
