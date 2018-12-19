package repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Entrada;

public class EntradaRepositorio {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EntradaRepositorio() {
		emf = Persistence.createEntityManagerFactory("Estacionamento");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Entrada entrada) {
		em.getTransaction().begin();
		em.persist(entrada);
		em.getTransaction().commit();
	}
	public void atualizar(Entrada entrada) {
		em.getTransaction().begin();
		em.merge(entrada);
		em.getTransaction().commit();
	}
	public void remover(Entrada entrada) {
		em.getTransaction().begin();
		em.remove(entrada);
		em.getTransaction().commit();
	}
	public Entrada recuperar(long id) {
		return em.find(Entrada.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Entrada> recuperarTodos(){
		return em.createNamedQuery("Todas.entradas").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
