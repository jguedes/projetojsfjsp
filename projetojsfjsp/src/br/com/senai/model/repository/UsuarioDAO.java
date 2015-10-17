package br.com.senai.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.senai.model.Usuario;

public class UsuarioDAO {

	public UsuarioDAO() {

	}

	public void excluir(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, id);
		em.remove(usuario);
		em.getTransaction().commit();

		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuario() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		Query query = em.createQuery("select u from Usuario u");

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarioDesvinculado() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		Query query = em.createQuery("select u from Usuario u where u not in " + "(select a.usuario from Aluno a)");

		return query.getResultList();
	}

	public void inserir(Usuario usuario) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();

		em.close();

	}

	public Usuario buscar(int idUsuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		return em.find(Usuario.class, idUsuario);
	}

	public void alterar(Usuario usuario) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();

		em.close();

	}

}
