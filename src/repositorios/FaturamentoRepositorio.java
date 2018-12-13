package repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Faturamento;

public class FaturamentoRepositorio {
	private EntityManagerFactory emf;
	private EntityManager em;
	public FaturamentoRepositorio() {
		emf = Persistence.createEntityManagerFactory("Estacionamento");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Faturamento faturamento) {
		em.getTransaction().begin();
		em.persist(faturamento);
		em.getTransaction().commit();
	}

	public void atualizar(Faturamento faturamento) {
		em.getTransaction().begin();
		em.merge(faturamento);
		em.getTransaction().commit();
	}

	public void remover(Faturamento faturamento) {
		em.getTransaction().begin();
		em.remove(faturamento);
		em.getTransaction().commit();
	}

	public Faturamento recuperar(long id) {
		return em.find(Faturamento.class, id);
	}
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Faturamento> recuperarTodos(){
		return em.createNamedQuery("Faturamento.todos").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Faturamento> recuperarPorData(String data){
		return em.createNamedQuery("Faturamento.porData").setParameter("date", "%"+data+"%").getResultList();
	}
}
