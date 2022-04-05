package br.com.fiap.main;

import java.util.List;

import br.com.fiap.entity.Livro;
import br.com.fiap.service.impl.LivroServiceImpl;

public class Main {
	public static void main(String[] args) {
		LivroServiceImpl livroService = LivroServiceImpl.getInstance();
		
		Livro livro1 = new Livro("Java", "Ferreira", "2a Edição", 2022);
		Livro livro2 = new Livro("Revolução do Bichos", "George Orwell", "1a Edição", 2007);
		Livro livro3 = new Livro("1984", "Carlos", "1a Edição", 2009);
		
		livroService.cadastrar(livro1);
		livroService.cadastrar(livro2);
		livroService.cadastrar(livro3);
		
		List<Livro> listaLivro = livroService.listar();
		listaLivro.forEach(System.out::println);
		
		livroService.remover(livro2.getId());
		
		livro3.setAnoPublicacao(2019);
		
		livroService.atualizar(livro3);
	}
}
