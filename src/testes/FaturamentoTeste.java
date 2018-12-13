package testes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entidades.Faturamento;
import repositorios.FaturamentoRepositorio;

public class FaturamentoTeste {
	public static void main(String[] args) {
		FaturamentoRepositorio fr = new FaturamentoRepositorio();
		
		Faturamento f1, f2, f3, f4, f5, fR;
		
		f1 = new Faturamento();
		f1.setDate(new SimpleDateFormat().format(new Date()));
		f1.setFaturamento(50.5);
		
		f2 = new Faturamento();
		f2.setDate(new SimpleDateFormat().format(new Date()));
		f2.setFaturamento(51.5);
		
		f3 = new Faturamento();
		f3.setDate(new SimpleDateFormat().format(new Date()));
		f3.setFaturamento(52.5);
		
		f4 = new Faturamento();
		f4.setDate(new SimpleDateFormat().format(new Date()));
		f4.setFaturamento(53.5);
		
		f5 = new Faturamento();
		f5.setDate(new SimpleDateFormat().format(new Date()));
		f5.setFaturamento(54.5);
		System.out.println("Adicionando");
		fr.adicionar(f1);
		fr.adicionar(f2);
		fr.adicionar(f3);
		fr.adicionar(f4);
		fr.adicionar(f5);
		
		List<Faturamento> faturamentos;
		faturamentos = fr.recuperarTodos();
		for (Faturamento faturamento : faturamentos) {
			System.out.println(faturamento);
		}
		System.out.println("Atualizando");
		Faturamento ff = fr.recuperar(1);
		ff.setFaturamento(15);
		faturamentos = fr.recuperarTodos();
		for (Faturamento faturamento : faturamentos) {
			System.out.println(faturamento);
		}
		System.out.println("Removendo");
		fr.remover(fr.recuperar(1));
		faturamentos = fr.recuperarTodos();
		for (Faturamento faturamento : faturamentos) {
			System.out.println(faturamento);
		}
		
		
		fr.encerrar();
	}
}
