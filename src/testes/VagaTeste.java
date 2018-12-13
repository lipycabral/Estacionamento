package testes;

import java.util.List;

import entidades.Vaga;
import repositorios.VagaRepositorio;

public class VagaTeste {
	public static void main(String[] args) {
		VagaRepositorio vr = new VagaRepositorio();
		Vaga v1, v2;
		
		v1 = new Vaga();
		v1.setId("E3");
		v1.setDescricao("Vaga especial 3");
		v1.setOcupado(false);
		
		v2 = new Vaga();
		v2.setId("E4");
		v2.setDescricao("Vaga especial 4");
		v2.setOcupado(false);
		System.out.println("Adicionando");
		vr.adicionar(v1);
		vr.adicionar(v2);
		
		List<Vaga> vagas;
		vagas = vr.recuperarTodos();
		for (Vaga vaga : vagas) {
			System.out.println(vaga);
		}
		System.out.println("Atualizando");
		Vaga vA = vr.recuperar("E4");
		vA.setDescricao("Vaga atualizada 4");
		vr.atualizar(vA);
		vagas = vr.recuperarTodos();
		System.out.println(vagas.size());
		for (Vaga vaga : vagas) {
			System.out.println(vaga);
		}
		System.out.println("Removendo");
		vr.remover(vr.recuperar("E4"));
		vagas = vr.recuperarTodos();
		for (Vaga vaga : vagas) {
			System.out.println(vaga);
		}
		
		vr.encerrar();
	}
}
