package testes;


import java.util.List;

import entidades.Inadimplente;
import repositorios.InadimplenteRepositorio;

public class InadimplenteTeste {
	public static void main(String[] args) {
		InadimplenteRepositorio ir = new InadimplenteRepositorio();
		Inadimplente i1, i2;
		i1 = new Inadimplente();
		i1.setCpf("36032816249");
		i1.setNome("Italo");
		
		i2 = new Inadimplente();
		i2.setCpf("11111111111");
		i2.setNome("Diego");
		System.out.println("Adicionando");
		ir.adicionar(i1);
		ir.adicionar(i2);
		List<Inadimplente> inadimplentes;
		inadimplentes = ir.recuperarTodos();
		for (Inadimplente inadimplente : inadimplentes) {
			System.out.println(inadimplente);
		}
		System.out.println("Atualizando");
		Inadimplente ia = ir.recuperar("36032816249");
		ia.setNome("Italo Jonatha");
		ir.atualizar(ia);
		inadimplentes = ir.recuperarTodos();
		for (Inadimplente inadimplente : inadimplentes) {
			System.out.println(inadimplente);
		}
		System.out.println("Removendo");
		ir.remover(ir.recuperar("36032816249"));
		inadimplentes = ir.recuperarTodos();
		for (Inadimplente inadimplente : inadimplentes) {
			System.out.println(inadimplente);
		}
		ir.encerrar();
		
		
	}
}
