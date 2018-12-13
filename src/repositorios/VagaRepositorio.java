package repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Vaga;

public class VagaRepositorio {
	private EntityManagerFactory emf;
	private EntityManager em;
	public VagaRepositorio() {
		emf = Persistence.createEntityManagerFactory("Estacionamento");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Vaga vaga) {
		em.getTransaction().begin();
		em.persist(vaga);
		em.getTransaction().commit();
	}
	
	public Vaga recuperar(String id) {
		return em.find(Vaga.class, id);
	}
	
	public void atualizar(Vaga vaga) {
		em.getTransaction().begin();
		em.merge(vaga);
		em.getTransaction().commit();
	}
	
	public void remover(Vaga vaga) {
		em.getTransaction().begin();
		em.remove(vaga);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Vaga> recuperarTodos(){
		return em.createNamedQuery("Vaga.todos").getResultList();
	}
	public void encerrar() {
		em.close();
		emf.close();
	}
}
