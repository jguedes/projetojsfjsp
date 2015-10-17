package br.com.senai.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.senai.model.ProjetoAcademico;

public class ProjetoAcademicoDAO {

	public ProjetoAcademicoDAO() {

	}

	public void excluir(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		ProjetoAcademico projetoAcademico = em.find(ProjetoAcademico.class, id);
		em.remove(projetoAcademico);
		em.getTransaction().commit();

		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<ProjetoAcademico> listarProjetoAcademico() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		Query query = em.createQuery("select u from ProjetoAcademico u");

		return query.getResultList();
	}

	/*
	 * @SuppressWarnings("unchecked") public List<ProjetoAcademico>
	 * listarUsuarioDesvinculado() {
	 * 
	 * EntityManagerFactory factory =
	 * Persistence.createEntityManagerFactory("projetojsfjsp");
	 * 
	 * EntityManager em = factory.createEntityManager();
	 * 
	 * Query query = em .createQuery(
	 * "select u from ProjetoAcademico u where u not in " +
	 * "(select a.usuario from Aluno a)");
	 * 
	 * return query.getResultList(); }
	 */

	public void inserir(ProjetoAcademico projetoAcademico) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.persist(projetoAcademico);
		em.getTransaction().commit();

		em.close();

	}

	public ProjetoAcademico buscar(int idProjetoAcademico) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		return em.find(ProjetoAcademico.class, idProjetoAcademico);
	}

	public void alterar(ProjetoAcademico projetoAcademico) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.merge(projetoAcademico);
		em.getTransaction().commit();

		em.close();

	}

}
