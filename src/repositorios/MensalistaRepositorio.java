package repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Mensalista;

public class MensalistaRepositorio {
	private EntityManagerFactory emf;
	private EntityManager em;
	public MensalistaRepositorio() {
		emf = Persistence.createEntityManagerFactory("Estacionamento");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Mensalista mensalista) {
		em.getTransaction().begin();
		em.persist(mensalista);
		em.getTransaction().commit();
	}
	
	public Mensalista recuperar(String cpf) {
		return em.find(Mensalista.class, cpf);
	}
	
	
	public void atualizar(Mensalista mensalista) {
		em.getTransaction().begin();
		em.merge(mensalista);
		em.getTransaction().commit();
	}
	
	public void remover(Mensalista mensalista) {
		em.getTransaction().begin();
		em.remove(mensalista);
		em.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	public List<Mensalista> recuperarTodos(){
		return em.createNamedQuery("Todos.mensalistas").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
