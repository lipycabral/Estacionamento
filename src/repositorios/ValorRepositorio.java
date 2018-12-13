package repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Valor;

public class ValorRepositorio {
	private EntityManagerFactory emf;
	private EntityManager em;
	public ValorRepositorio() {
		emf = Persistence.createEntityManagerFactory("Estacionamento");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Valor valor) {
		em.getTransaction().begin();
		em.persist(valor);
		em.getTransaction().commit();
	}
	
	public Valor recuperar(String id) {
		return em.find(Valor.class, id);
	}
	
	public void atualizar(Valor valor) {
		em.getTransaction().begin();
		em.merge(valor);
		em.getTransaction().commit();
	}
	public void remover(Valor valor) {
		em.getTransaction().begin();
		em.remove(valor);
		em.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	public List<Valor> recuperarTodo(){
		return em.createNamedQuery("Todos.valor").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
