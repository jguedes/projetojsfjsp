package br.com.senai.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.senai.model.Aluno;

public class AlunoDAO {

	public AlunoDAO() {

	}

	public void excluir(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Aluno aluno = em.find(Aluno.class, id);
		em.remove(aluno);
		em.getTransaction().commit();

		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listarAluno() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		Query query = em.createQuery("select u from Aluno u");

		return query.getResultList();
	}

	public void inserir(Aluno aluno) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();

		em.close();

	}

	public Aluno buscar(int idAluno) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		return em.find(Aluno.class, idAluno);
	}

	public void alterar(Aluno aluno) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetojsfjsp");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();

		em.close();

	}

}
