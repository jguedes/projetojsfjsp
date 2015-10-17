package br.com.senai.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.senai.model.Telefone;
import br.com.senai.model.Usuario;

public class TelefoneDAO {

	public TelefoneDAO() {

	}

	public void inserir(Telefone telefone) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.persist(telefone);
		em.getTransaction().commit();

		em.close();

	}

	@SuppressWarnings("unchecked")
	public List<Telefone> listarPorUSuario(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		Query query = em.createQuery("select t from Telefone t where t.usuario = :usuario");
		query.setParameter("usuario", usuario);

		return query.getResultList();
	}

	public void excluir(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Telefone telefone = em.find(Telefone.class, id);
		em.remove(telefone);
		em.getTransaction().commit();

		em.close();
	}

}
