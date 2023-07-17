package Biblioteca;

import Livro.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Livro> livros;
	
	public Biblioteca() {
		this.livros = new ArrayList<>();
	}

	public void adicionarLivro(Livro livro) {
		livros.add(livro);
		System.out.println("Livro adicionado à biblioteca: " + livro.getTitulo());
	}
	

	public void removerLivro(Livro livro) {
		if (livros.remove(livro)) {
			System.out.println("Livro removido da biblioteca: " + livro.getTitulo());
		} else {
			System.out.println("Livro não encontrado na biblioteca: " + livro.getTitulo());
		}
	}
	
	public Livro pesquisarLivro(String titulo) {
		for (Livro livro : livros) {
			if (livro.getTitulo().equalsIgnoreCase(titulo)) {
				return livro;
			}
		}
		
		return null;
	}

	public void exibirLivrosDisponiveis() {
		System.out.println("Livros disponíveis na biblioteca:");
		for (Livro livro : livros) {
			if (livro.isDisponibilidade()) {
				System.out.println("Título: " + livro.getTitulo());
				System.out.println("Autor: " + livro.getAutor());
			}
		}
	}
}
