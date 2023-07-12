package Testes;

import Livro.Livro;
import Biblioteca.Biblioteca;
import Usuario.Usuario;

public class MainBiblioteca {

	public static void main(String[] args) {
		// Testes da classe Usuario
		Usuario usuario = new Usuario("João", "senha123", "000.000.000-00", "Francisco celso Nº00");
		
		usuario.criarUsuario("Maria", "senha456", "001.001.001-01","Afonso nobrega Nº01");

		System.out.println("");
		System.out.println("Nome do usuário: " + usuario.getNome());
		System.out.println("Senha do usuário: " + usuario.getSenha());

		Livro livro1 = new Livro("Livro 1", "Autor 1");
		Livro livro2 = new Livro("Livro 2", "Autor 2");

		usuario.solicitarEmprestimo(livro1);
		usuario.solicitarEmprestimo(livro2);

		System.out.printf("%nLivros emprestados pelo usuário:%n");
		for (Livro livro : usuario.getListaLivrosEmprestados()) {
			System.out.println("Título: " + livro.getTitulo());
			System.out.printf("Autor: "  + livro.getAutor());
			System.out.println("");
		}
		
		//Teste Livros

		usuario.devolverLivro(livro1);

		System.out.println("Livros emprestados pelo usuário após a devolução:");
		for (Livro livro : usuario.getListaLivrosEmprestados()) {
			System.out.println("Título: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor());
		}

		System.out.println();

	
		Livro livro3 = new Livro("Livro 3", "Autor 3");

		livro3.obterInformacaoLivros();
		livro3.alterarStatusDisponibilidade(false);
		livro3.obterInformacaoLivros();

		System.out.println();

		// Testes da classe Biblioteca
		Biblioteca biblioteca = new Biblioteca();

		biblioteca.adicionarLivro(livro1);
		biblioteca.adicionarLivro(livro2);
		biblioteca.adicionarLivro(livro3);

		biblioteca.exibirLivrosDisponiveis();

		biblioteca.removerLivro(livro1);

		biblioteca.exibirLivrosDisponiveis();
	}

}
