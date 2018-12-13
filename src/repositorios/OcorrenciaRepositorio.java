package repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Ocorrencia;

public class OcorrenciaRepositorio {
	EntityManagerFactory emf;
	EntityManager em;
	public OcorrenciaRepositorio() {
		emf = Persistence.createEntityManagerFactory("Estacionamento");
		em = emf.createEntityManager();
	}

	public void adicionar(Ocorrencia ocorrencia) {
		em.getTransaction().begin();
		em.persist(ocorrencia);
		em.getTransaction().commit();
	}
	public Ocorrencia recuperar(long id) {
		return em.find(Ocorrencia.class, id);
	}
	public void atualizar(Ocorrencia ocorrencia) {
		em.getTransaction().begin();
		em.merge(ocorrencia);
		em.getTransaction().commit();
	}
	public void remover(Ocorrencia ocorrencia) {
		em.getTransaction().begin();
		em.remove(ocorrencia);
		em.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	public List<Ocorrencia> recuperarTodos(){
		return em.createNamedQuery("Recuperar.todos").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
