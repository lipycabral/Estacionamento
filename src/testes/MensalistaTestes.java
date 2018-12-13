package testes;

import java.util.List;

import entidades.Mensalista;
import entidades.Placa;
import repositorios.MensalistaRepositorio;

public class MensalistaTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MensalistaRepositorio mr = new MensalistaRepositorio();
		Placa p1, p2, p3, p4, p5, p6;
		p1 = new Placa();
		p1.setPlaca("ABC1234");
		
		p2 = new Placa();
		p2.setPlaca("DEF1234");
		
		p3 = new Placa();
		p3.setPlaca("GHI1234");
		
		p4 = new Placa();
		p4.setPlaca("FHI1234");
		
		p5 = new Placa();
		p5.setPlaca("JKL1234");
		
		p6 = new Placa();
		p6.setPlaca("MNO1234");
		
		Mensalista m1, m2;
		
		m1 = new Mensalista();
		m1.setBairro("Adalberto sena");
		m1.setCidade("Rio Branco");
		m1.setCpf("36032816249");
		m1.setNome("Italo jonatan");
		m1.setRua("25 de Dezembro");
		m1.setUf("Ac");
		m1.setNum(31);
		
		m2 = new Mensalista();
		m2.setBairro("Xavier Maia");
		m2.setCidade("Rio Branco");
		m2.setCpf("52226727272");
		m2.setNome("Felipy Cabral");
		m2.setRua("Jambo");
		m2.setUf("Ac");
		m2.setNum(13);
		
		
		
		m1.adicionarPlaca(p1);
		m1.adicionarPlaca(p2);
		m1.adicionarPlaca(p3);
		mr.adicionar(m1);
		m2.adicionarPlaca(p4);
		m2.adicionarPlaca(p5);
		m2.adicionarPlaca(p6);
		mr.adicionar(m2);
		
		System.out.println("Adicionando");
		List<Mensalista> mensalistas;
		mensalistas = mr.recuperarTodos();
		for (Mensalista mensalista : mensalistas) {
			System.out.println(mensalista);
		}
		System.out.println("Removendo placas e atualizando");
		Mensalista mA;
		mA = mr.recuperar("36032816249");
		Placa pR = mA.getPlacaEspecifica("ABC1234");
		mA.removerPlaca(pR);
		mr.atualizar(mA);
		mensalistas = mr.recuperarTodos();
		for (Mensalista mensalista : mensalistas) {
			System.out.println(mensalista);
		}
		System.out.println("Removendo");
		mr.remover(mr.recuperar("36032816249"));
		mensalistas = mr.recuperarTodos();
		for (Mensalista mensalista : mensalistas) {
			System.out.println(mensalista);
		}
		
		mr.encerrar();
	}

}
