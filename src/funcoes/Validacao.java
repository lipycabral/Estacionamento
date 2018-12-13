package funcoes;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Usuario;

public class Validacao {
	private EntityManagerFactory emf;
	private EntityManager em;
	public Validacao() {
		// TODO Auto-generated constructor stub
		emf = Persistence.createEntityManagerFactory("Estacionamento");
		em = emf.createEntityManager();
	}
	public boolean login(String usuario, String senha) {
		Usuario u;
		if(recuperarUsuario(usuario)!=null) {
			u = recuperarUsuario(usuario);
			
			if(senha.equals(u.getSenha())) {
				return true;
			} else {
				System.out.println("Senha errada");
			}
		} else {
			System.out.println("Usuario não encontrado");
		}
		return false;
	}
	public Usuario recuperarUsuario(String cpf) {
		return em.find(Usuario.class, cpf);
	}
}
