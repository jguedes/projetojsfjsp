package br.com.senai.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.senai.fachada.Fachada;
import br.com.senai.model.Usuario;

@ManagedBean
public class UsuarioEditMB {

	private Usuario usuario;

	private Fachada fachada;

	public boolean isFluxoAlterar() {
		return usuario.getId() != 0;
	}

	@PostConstruct
	private void init() {
		usuario = new Usuario();
	}

	public void preAlterar(Usuario usuario) {
		setUsuario(usuario);
	}

	public String salvar() {
		if (isFluxoAlterar()) {
			getFachada().alterarUsuario(usuario);
		} else {
			getFachada().inserirUsuario(usuario);
		}
		return "success";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
