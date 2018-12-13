package testes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entidades.Entrada;
import repositorios.EntradaRepositorio;

public class EntradaTeste {
	public static void main(String[] args) {
		EntradaRepositorio er = new EntradaRepositorio();
		Entrada e1, e2;
		e1 = new Entrada();
		Date d = new Date();
		e1.setEntrada(d);
		e1.setValor(11.2);
		
		e2 = new Entrada();
		e2.setEntrada(d);
		e2.setValor(12);
		System.out.println("Adicionando");
		er.adicionar(e1);
		er.adicionar(e2);
		
		List<Entrada> entradas;
		entradas = er.recuperarTodos();
		for (Entrada entrada : entradas) {
			System.out.println(entrada);
		}
		
		Entrada ea = er.recuperar(1);
		ea.setValor(13);
		
		System.out.println("Atualizando");
		er.atualizar(ea);
		entradas = er.recuperarTodos();
		for (Entrada entrada : entradas) {
			System.out.println(entrada);
		}
		System.out.println("Removendo");
		er.remover(er.recuperar(1));
		entradas = er.recuperarTodos();
		for (Entrada entrada : entradas) {
			System.out.println(entrada);
		}
		er.encerrar();
	}
}
