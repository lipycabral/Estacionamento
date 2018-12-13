package repositorios;

import java.util.List;
import java.util.Base64;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Atendente;
import entidades.Usuario;

public class AtendenteRepositorio {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Usuario usuario;
	public AtendenteRepositorio() {
		emf = Persistence.createEntityManagerFactory("Estacionamento");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Atendente atendente) {
		
		usuario = new Usuario();
		usuario.setUsuario(atendente.getCpf());
		usuario.setSenha(Base64.getEncoder().encodeToString(atendente.getCpf().getBytes()));
		atendente.setUsuario(usuario);
		
		em.getTransaction().begin();
		em.persist(atendente);
		em.persist(usuario);
		em.getTransaction().commit();
		
		
	}
	public Atendente recuperar(String cpf) {
		return em.find(Atendente.class, cpf);
	}
	public Usuario recuperarUsuario(String cpf) {
		return em.find(Usuario.class, cpf);
	}
	public void atualizar(Atendente atendente) {
		em.getTransaction().begin();
		em.merge(atendente);
		em.getTransaction().commit();
	}
	public void remover(Atendente atendente) {
		usuario = recuperarUsuario(atendente.getCpf());
		em.getTransaction().begin();
		em.remove(atendente);
		em.remove(usuario);
		em.getTransaction().commit();
	}
	public void encerrar() {
		em.close();
		emf.close();
	}
	@SuppressWarnings("unchecked")
	public List<Atendente> recuperarTodos(){
		return em.createNamedQuery("Todos.atendentes").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Atendente> recuperarTodosPorNome(){
		return em.createNamedQuery("Todos.atendentesPorNome").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Atendente> recuperarTodosPorNomeEspecifico(String nome){
		return em.createNamedQuery("Todos.atendentesPorNomeEspecifico")
				.setParameter("nome", "%"+nome+"%")
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Atendente> recuperarTodosPorCpf(){
		return em.createNamedQuery("Todos.atendentesPorCpf").getResultList();
	}
}
