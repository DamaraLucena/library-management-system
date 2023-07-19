package com.github.damaralucena.Main;

import java.util.Scanner;

import com.github.damaralucena.Biblioteca.Biblioteca;
import com.github.damaralucena.Livro.Livro;
import com.github.damaralucena.Usuario.Usuario;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Biblioteca biblioteca = new Biblioteca();
		Usuario usuario = null;

		int menu;

		do {
			exibirMenu();
			menu = scanner.nextInt();
			scanner.nextLine();

			try {
				switch (menu) {
				case 1:
					System.out.println("Digite o nome do usuário: ");
					String nome = scanner.nextLine();
					System.out.println("Digite a senha do usuário: ");
					String senha = scanner.nextLine();
					System.out.println("Digite o CPF do usuário: ");
					String cpf = scanner.nextLine();
					System.out.println("Digite o endereço do usuário: ");
					String endereco = scanner.nextLine();

					usuario = new Usuario(nome, senha, endereco, cpf);
					
					System.out.println(" ");
					System.out.println("Usuário criado com sucesso!");

					break;

				case 2:
					if (usuario == null) {
						System.out.println("Não a registro do usuário. Registre um usuário primeiro.");
						break;
					}

					System.out.println("Digite o título do livro: ");
					String titulo = scanner.nextLine();
					System.out.println("Digite o autor do livro: ");
					String autor = scanner.nextLine();
					Livro livro = new Livro(titulo, autor);

					biblioteca.adicionarLivro(livro);

					break;

				case 3:
					if (usuario == null) {
						System.out.println("Não a registro do usuário. Registre um usuário primeiro.");
						break;
					}

					System.out.println("Digite o título do livro para empréstimo:");
					String tituloEmprestimo = scanner.nextLine();

					Livro livroEmprestimo = biblioteca.pesquisarLivro(tituloEmprestimo);

					if (livroEmprestimo != null && livroEmprestimo.isDisponibilidade()) {
						usuario.solicitarEmprestimo(livroEmprestimo);
						livroEmprestimo.setDisponibilidade(false);
						System.out.println("Empréstimo realizado com sucesso.");

					} else {
						System.out.println("Livro não encontrado na biblioteca ou indisponível para empréstimo.");

					}

					break;

				case 4:
					if (usuario == null) {
						System.out.println("Não a registro do usuário. Registre um usuário primeiro.");
						break;
					}

					System.out.println("Digite o título do livro para devolução:");
					String tituloDevolucao = scanner.nextLine();

					Livro livroDevolucao = usuario.buscarLivroEmprestado(tituloDevolucao);

					if (livroDevolucao != null) {
						usuario.devolverLivro(livroDevolucao);
						livroDevolucao.setDisponibilidade(true);
						System.out.println("Devolução realizada com sucesso.");

					} else {
						System.out.println("Você não possui este livro emprestado.");
					}

					break;

				case 5:
					biblioteca.exibirLivrosDisponiveis();

					break;

				case 6:
					if (usuario == null) {
						System.out.println("Não a registro do usuário. Registre um usuário primeiro.");

						break;

					}

					usuario.exibirLivrosEmprestados();
					break;

				case 0:
					System.out.println("Encerrando o processo...");
					break;

				default:
					System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
					break;
				}

			} catch (Exception e) {
				System.out.println("Ocorreu um erro: " + e.getMessage());
			}

			System.out.println(" ");

		} while (menu != 0);

		scanner.close();
	}

	private static void exibirMenu() {
		System.out.println("====== MENU ======");
		System.out.println("");
		System.out.println("Informe a opção desejada:");
		System.out.println("");
		System.out.println("1. Criar usuário");
		System.out.println("2. Adicionar livro");
		System.out.println("3. Solicitar empréstimo de livro");
		System.out.println("4. Devolver livro");
		System.out.println("5. Exibir livros disponíveis");
		System.out.println("6. Exibir livros emprestados");
		System.out.println("0. Sair do programa");
		System.out.println(" ");
		System.out.println("====================");
	}

}
