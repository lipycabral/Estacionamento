package testes;

import java.util.List;

import entidades.Valor;
import repositorios.ValorRepositorio;

public class ValorTeste {
	public static void main(String[] args) {
		ValorRepositorio vr = new ValorRepositorio();
		Valor v1, v2;
		
		v1 = new Valor();
		v1.setId("DM");
		v1.setDescricao("Diaria Moto");
		v1.setValor(11.50);
		
		v2 = new Valor();
		v2.setId("DC");
		v2.setDescricao("Diaria Carro");
		v2.setValor(13.50);
		System.out.println("Adicionando");
		vr.adicionar(v1);
		vr.adicionar(v2);
		
		List<Valor> valores;
		valores = vr.recuperarTodo();
		for (Valor valor : valores) {
			System.out.println(valor);
		}
		System.out.println("Atualizando");
		Valor vA = vr.recuperar("DM");
		vA.setValor(15);
		vr.atualizar(vA);
		valores = vr.recuperarTodo();
		for (Valor valor : valores) {
			System.out.println(valor);
		}
		System.out.println("Removendo");
		vr.remover(vr.recuperar("DM"));
		valores = vr.recuperarTodo();
		for (Valor valor : valores) {
			System.out.println(valor);
		}
		
		vr.encerrar();
	}

}
