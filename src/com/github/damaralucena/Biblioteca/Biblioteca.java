package com.github.damaralucena.Biblioteca;

import java.sql.*;

import java.util.Scanner;

import com.github.damaralucena.DataBase.DataBaseConfig;


public class Biblioteca {
	private Connection connection;

	public void ConectarBiblioteca() {
		try {
			connection = DataBaseConfig.getConnection();
			System.out.println("Conexão com o banco de dados estabelecida!");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
	}
	
	public void desconectarBiblioteca() {
        try {
            connection.close();
            System.out.println("Conexão com o banco de dados encerrada!");
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar do banco de dados: " + e.getMessage());
        }
    }
	
	public void adicionarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Informe o autor do livro:");
        String autor = scanner.nextLine();
        System.out.println("O livro está disponível para empréstimo? (true/false)");
        boolean disponivel = scanner.nextBoolean();

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO livros (titulo, autor, disponivel) VALUES (?, ?, ?)");
            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setBoolean(3, disponivel);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Livro adicionado com sucesso!");
            } else {
                System.out.println("Não foi possível adicionar o livro.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar livro: " + e.getMessage());
        }
    }

    public void removerLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do livro que deseja remover:");
        int id = scanner.nextInt();

        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM livros WHERE id = ?");
            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Livro removido com sucesso!");
            } else {
                System.out.println("Não foi possível remover o livro.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover livro: " + e.getMessage());
        }
    }

    public void pesquisarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o título ou autor do livro que deseja pesquisar:");
        String termo = scanner.nextLine();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM livros WHERE titulo ILIKE ? OR autor ILIKE ?");
            stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, "%" + termo + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                boolean disponivel = rs.getBoolean("disponivel");
                System.out.println("ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Disponível: " + disponivel);
            }

            if (!rs.next()) {
                System.out.println("Nenhum livro encontrado com o termo informado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar livro: " + e.getMessage());
        }
    }

    public void exibirLivrosDisponiveis() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM livros WHERE disponivel = true");

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                System.out.println("ID: " + id + ", Título: " + titulo + ", Autor: " + autor);
            }

            if (!rs.next()) {
                System.out.println("Nenhum livro disponível no momento.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao exibir livros disponíveis: " + e.getMessage());
        }
    }

    public void adicionarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do usuário:");
        String nome = scanner.nextLine();
        System.out.println("Informe a senha do usuário:");
        String senha = scanner.nextLine();
        System.out.println("Informe o cpf do usuário: ");
        String cpf = scanner.nextLine();
        System.out.println("Informe o endereco do usuário: ");
        String endereco = scanner.nextLine();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO usuarios (nome, senha, cpf, endereco) VALUES (?, ?, ?, ?)");
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            stmt.setString(3, cpf);
            stmt.setString(4, endereco);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário adicionado com sucesso!");
            } else {
                System.out.println("Não foi possível adicionar o usuário.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }

    public void pesquisarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do usuário que deseja pesquisar:");
        String nome = scanner.nextLine();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios WHERE nome ILIKE ?");
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nomeUsuario = rs.getString("nome");
                System.out.println("ID: " + id + ", Nome: " + nomeUsuario);
            }

            if (!rs.next()) {
                System.out.println("Nenhum usuário encontrado com o nome informado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar usuário: " + e.getMessage());
        }
    }

    public void atualizarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do usuário que deseja atualizar:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o novo nome do usuário:");
        String novoNome = scanner.nextLine();

        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE usuarios SET nome = ? WHERE id = ?");
            stmt.setString(1, novoNome);
            stmt.setInt(2, id);
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Não foi possível atualizar o usuário. Verifique se o ID informado está correto.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    public void atualizarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do livro que deseja atualizar:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o novo título do livro:");
        String novoTitulo = scanner.nextLine();
        System.out.println("Informe o novo autor do livro:");
        String novoAutor = scanner.nextLine();
        System.out.println("O livro está disponível para empréstimo? (true/false)");
        boolean novoDisponivel = scanner.nextBoolean();

        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE livros SET titulo = ?, autor = ?, disponivel = ? WHERE id = ?");
            stmt.setString(1, novoTitulo);
            stmt.setString(2, novoAutor);
            stmt.setBoolean(3, novoDisponivel);
            stmt.setInt(4, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Livro atualizado com sucesso!");
            } else {
                System.out.println("Não foi possível atualizar o livro. Verifique se o ID informado está correto.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }
}