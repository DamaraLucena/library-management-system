package com.github.damaralucena.Main;
import com.github.damaralucena.Biblioteca.*;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	     Biblioteca biblioteca = new Biblioteca();
	     
	       biblioteca.ConectarBiblioteca();

	        int opcao;
	        do {
	            System.out.println("\n=== Menu ===");
	            System.out.println("1. Adicionar Livro");
	            System.out.println("2. Remover Livro");
	            System.out.println("3. Pesquisar Livro");
	            System.out.println("4. Exibir Livros Disponíveis");
	            System.out.println("5. Adicionar Usuário");
	            System.out.println("6. Pesquisar Usuário");
	            System.out.println("7. Atualizar Usuário");
	            System.out.println("8. Atualizar Livro");
	            System.out.println("0. Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    biblioteca.adicionarLivro();
	                    break;
	                case 2:
	                    biblioteca.removerLivro();
	                    break;
	                case 3:
	                    biblioteca.pesquisarLivro();
	                    break;
	                case 4:
	                    biblioteca.exibirLivrosDisponiveis();
	                    break;
	                case 5:
	                    biblioteca.adicionarUsuario();
	                    break;
	                case 6:
	                    biblioteca.pesquisarUsuario();
	                    break;
	                case 7:
	                    biblioteca.atualizarUsuario();
	                    break;
	                case 8:
	                    biblioteca.atualizarLivro();
	                    break;
	                case 0:
	                    System.out.println("Encerrando o programa...");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Por favor, escolha novamente.");
	            }

	        } while (opcao != 0);

	        biblioteca.desconectarBiblioteca();

	        scanner.close();
	    }

}
