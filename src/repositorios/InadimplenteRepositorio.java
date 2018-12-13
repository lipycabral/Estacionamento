package repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Entrada;
import entidades.Inadimplente;;

public class InadimplenteRepositorio {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public InadimplenteRepositorio() {
		emf = Persistence.createEntityManagerFactory("Estacionamento");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Inadimplente inadimplente) {
		em.getTransaction().begin();
		em.persist(inadimplente);
		em.getTransaction().commit();
	}
	public void atualizar(Inadimplente inadimplente) {
		em.getTransaction().begin();
		em.merge(inadimplente);
		em.getTransaction().commit();
	}
	public void remover(Inadimplente inadimplente) {
		em.getTransaction().begin();
		em.remove(inadimplente);
		em.getTransaction().commit();
	}
	public Inadimplente recuperar(String cpf) {
		return em.find(Inadimplente.class, cpf);
	}
	@SuppressWarnings("unchecked")
	public List<Inadimplente> recuperarTodos(){
		return em.createNamedQuery("Todos.inadimplentes").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
