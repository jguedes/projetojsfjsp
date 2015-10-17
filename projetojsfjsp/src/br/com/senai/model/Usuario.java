package br.com.senai.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@Column(name = "senha", length = 10, nullable = false)
	private String senha;

	@Column(name = "email", length = 30, nullable = false)
	private String email;

	@Transient
	private List<Telefone> listaTelefone;

	public Usuario() {

	}

	public Usuario(int id, String nome, String senha, String email) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	public Usuario(String nome, String senha, String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	@Override
	public String toString() {

		return this.nome;

	}

	@Override
	public boolean equals(Object obj) {

		return ((Usuario) obj).nome.equals(this.nome);

	}

}
