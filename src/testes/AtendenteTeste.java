package testes;

import java.util.List;

import entidades.Atendente;
import repositorios.AtendenteRepositorio;

public class AtendenteTeste {

	public static void main(String[] args) {
		AtendenteRepositorio ar = new AtendenteRepositorio();
		
		Atendente a1, a2;
		
//		Scanner scan = new Scanner(System.in);
		
		a1 = new Atendente();
		a1.setBairro("Xavier Maia");
		a1.setCidade("Rio Branco");
		a1.setCpf("52226727272");
		a1.setNome("Felipy Cabral");
		a1.setNumero(15);
		a1.setRua("Jambo");
		a1.setUf("Ac");
		
		
		a2 = new Atendente();
		a2.setBairro("Adalberto sena");
		a2.setCidade("Rio Branco");
		a2.setCpf("36032816249");
		a2.setNome("Italo jonatan");
		a2.setNumero(30);
		a2.setRua("25 de Dezembro");
		a2.setUf("Ac");
		
		ar.adicionar(a1);
		ar.adicionar(a2);
		System.out.println("Adicionados");
		List<Atendente> atendentes;
		atendentes = ar.recuperarTodos();
		for (Atendente atendente : atendentes) {
			System.out.println(atendente);
		}
		
		Atendente italo = ar.recuperar("36032816249");
		italo.setNome("Italo Jonatha Cardoso");
		System.out.println("Atualizando");
		ar.atualizar(italo);
		atendentes = ar.recuperarTodos();
		atendentes = ar.recuperarTodos();
		for (Atendente atendente : atendentes) {
			System.out.println(atendente);
		}
		System.out.println("Recuperando Italo");
		System.out.println(ar.recuperar("36032816249"));
		System.out.println("Removendo");
		ar.remover(ar.recuperar("52226727272"));
		atendentes = ar.recuperarTodos();
		for (Atendente atendente : atendentes) {
			System.out.println(atendente);
		}
		ar.encerrar();
	}

}
