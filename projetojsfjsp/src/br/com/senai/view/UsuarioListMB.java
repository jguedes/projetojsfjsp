package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DualListModel;

import br.com.senai.fachada.Fachada;
import br.com.senai.model.Usuario;

@ManagedBean
public class UsuarioListMB {

	private List<Usuario> listaUsuario;

	private List<Usuario> targetListaUsuario;

	private Fachada fachada;

	@PostConstruct
	private void init() {
		setListaUsuario(listarUsuario());
	}

	public DualListModel<Usuario> listModelUsuario() {

		targetListaUsuario = new ArrayList<Usuario>();

		return new DualListModel<Usuario>(listaUsuario, targetListaUsuario);

	}

	private List<Usuario> listarUsuario() {
		return getFachada().listarUsuario();
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public void excluir(Usuario usuario) {
		getFachada().excluirUsuario(usuario);
		setListaUsuario(listarUsuario());
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
