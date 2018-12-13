package testes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entidades.Ocorrencia;
import repositorios.OcorrenciaRepositorio;

public class OcorrenciaTeste {
	
	public static void main(String[] args) {
		Date date = new Date();
		OcorrenciaRepositorio or = new OcorrenciaRepositorio();
		Ocorrencia o1, o2, o3;
		o1 = new Ocorrencia();
		o1.setData(date);
		o1.setDescricao("Fulano X agrediu fulano Y");
		
		o2 = new Ocorrencia();
		o2.setData(date);
		o2.setDescricao("Batida de carro");
		
		o3 = new Ocorrencia();
		o3.setData(date);
		o3.setDescricao("testando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanhotestando o tamanho");
		System.out.println("Adicionando");
		or.adicionar(o1);
		or.adicionar(o2);
		or.adicionar(o3);
		List<Ocorrencia> ocorrencias;
		ocorrencias = or.recuperarTodos();
		for (Ocorrencia ocorrencia : ocorrencias) {
			System.out.println(ocorrencia);
		}
		System.out.println("Atualizando");
		Ocorrencia oA = or.recuperar(1);
		oA.setDescricao("Atualizando");
		or.atualizar(oA);
		ocorrencias = or.recuperarTodos();
		for (Ocorrencia ocorrencia : ocorrencias) {
			System.out.println(ocorrencia);
		}
		System.out.println("Removendo");
		or.remover(or.recuperar(1));
		ocorrencias = or.recuperarTodos();
		for (Ocorrencia ocorrencia : ocorrencias) {
			System.out.println(ocorrencia);
		}
		
		or.encerrar();
	}

}
