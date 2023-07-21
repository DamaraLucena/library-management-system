package com.github.damaralucena.Main;
import com.github.damaralucena.Biblioteca.*;
import com.github.damaralucena.Livro.*;
import com.github.damaralucena.Usuario.*;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	     Biblioteca biblioteca = new Biblioteca();

	        int escolha;
	        do {
	            System.out.println("===== Sistema de Gerenciamento de Bibliotecas =====");
	            System.out.println("1. Cadastrar novo usuário");
	            System.out.println("2. Cadastrar novo livro");
	            System.out.println("3. Solicitar empréstimo de livro");
	            System.out.println("4. Devolver livro");
	            System.out.println("5. Pesquisar livros disponíveis");
	            System.out.println("0. Sair");
	            System.out.println("===================================================");

	            System.out.print("Escolha uma opção: ");
	            escolha = scanner.nextInt();
	            scanner.nextLine();

	            switch (escolha) {
	                case 1:
	                    cadastrarNovoUsuario(scanner, biblioteca);
	                    break;
	                case 2:
	                    cadastrarNovoLivro(scanner, biblioteca);
	                    break;
	                case 3:
	                    solicitarEmprestimo(scanner, biblioteca);
	                    break;
	                case 4:
	                    devolverLivro(scanner, biblioteca);
	                    break;
	                case 5:
	                    exibirLivrosDisponiveis(biblioteca);
	                    break;
	                case 0:
	                    System.out.println("Saindo...");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	            }
	        } while (escolha != 0);

	        scanner.close();
	    }

	    private static void cadastrarNovoUsuario(Scanner scanner, Biblioteca biblioteca) {
	        System.out.print("Digite o nome: ");
	        String nome = scanner.nextLine();
	        System.out.print("Digite a senha: ");
	        String senha = scanner.nextLine();
	        System.out.println("Digite o cpf: ");
	        String cpf = scanner.nextLine();
	        System.out.println("Digite o endereço: ");
	        String endereco = scanner.nextLine();

	        Usuario novoUsuario = new Usuario(0, nome, senha, cpf, endereco);
	        biblioteca.adicionarUsuario(novoUsuario);
	        System.out.println("Usuário cadastrado com sucesso!");
	    }

	    private static void cadastrarNovoLivro(Scanner scanner, Biblioteca biblioteca) {
	        System.out.print("Digite o título do livro: ");
	        String titulo = scanner.nextLine();
	        System.out.print("Digite o autor do livro: ");
	        String autor = scanner.nextLine();

	        Livro novoLivro = new Livro(titulo, autor, true);
	        biblioteca.adicionarLivro(novoLivro);
	        System.out.println("Livro cadastrado com sucesso!");
	    }

	    private static void solicitarEmprestimo(Scanner scanner, Biblioteca biblioteca) {
	        System.out.print("Digite o ID do usuário que deseja solicitar o empréstimo: ");
	        int usuarioId = scanner.nextInt();
	        scanner.nextLine(); //

	        System.out.print("Digite o ID do livro que deseja solicitar o empréstimo: ");
	        int livroId = scanner.nextInt();
	        scanner.nextLine();

	        Usuario usuario = biblioteca.pesquisarUsuario(usuarioId);
	        Livro livro = biblioteca.pesquisarLivro(livroId);

	        if (usuario != null && livro != null && livro.isDisponibilidade()) {
	            usuario.solicitarEmprestimo(livro);
	            biblioteca.atualizarUsuario(usuario);
	            biblioteca.atualizarLivro(livro);
	            System.out.println("Empréstimo realizado com sucesso!");
	        } else {
	            System.out.println("Usuário ou livro não encontrado ou livro não disponível para empréstimo.");
	        }
	    }

	    private static void devolverLivro(Scanner scanner, Biblioteca biblioteca) {
	        System.out.print("Digite o ID do usuário que deseja devolver o livro: ");
	        int usuarioId = scanner.nextInt();
	        scanner.nextLine();

	        System.out.print("Digite o ID do livro que deseja devolver: ");
	        int livroId = scanner.nextInt();
	        scanner.nextLine(); 

	        Usuario usuario = biblioteca.pesquisarUsuario(usuarioId);
	        Livro livro = biblioteca.pesquisarLivro(livroId);

	        if (usuario != null && livro != null && !livro.isDisponibilidade()) {
	            usuario.devolverLivro(livro);
	            biblioteca.atualizarUsuario(usuario);
	            biblioteca.atualizarLivro(livro);
	            System.out.println("Livro devolvido com sucesso!");
	        } else {
	            System.out.println("Usuário ou livro não encontrado ou livro já disponível.");
	        }
	    }

	    private static void exibirLivrosDisponiveis(Biblioteca biblioteca) {
	        List<Livro> livrosDisponiveis = biblioteca.exibirLivrosDisponiveis();
	        if (livrosDisponiveis.isEmpty()) {
	            System.out.println("Nenhum livro disponível na biblioteca.");
	        } else {
	            System.out.println("Livros disponíveis na biblioteca:");
	            for (Livro livro : livrosDisponiveis) {
	                System.out.println("ID: " + livro.getId());
	                System.out.println("Título: " + livro.getTitulo());
	                System.out.println("Autor: " + livro.getAutor());
	                System.out.println("--------------------");
	            }
	        }
	    }

}
