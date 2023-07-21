package com.github.damaralucena.Biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.github.damaralucena.DataBase.DataBaseConfig;
import com.github.damaralucena.Livro.Livro;
import com.github.damaralucena.Usuario.Usuario;

public class Biblioteca {
	private Connection connection;

	public Biblioteca() {
		try {
			connection = DataBaseConfig.getConnection();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
	}
	
	public void adicionarUsuario(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int usuarioId = generatedKeys.getInt(1);
                usuario.setId(usuarioId);
            }

            System.out.println("Usuário cadastrado com sucesso no banco de dados.");
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar usuário ao banco de dados: " + e.getMessage());
        }
    }
	
	public void atualizarUsuario(Usuario usuario) {
        try {
            String sql = "UPDATE usuarios SET nome = ?, senha = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso no banco de dados.");
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar usuário no banco de dados: " + e.getMessage());
        }
    }
	
	public Usuario pesquisarUsuario(int usuarioId) {
        Usuario usuario = null;
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, usuarioId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String cpf = resultSet.getString("cpf");
                String endereco = resultSet.getString("endereco");
                usuario = new Usuario(usuarioId, nome, senha, cpf, endereco);
            } else {
                System.out.println("Usuário com ID " + usuarioId + " não encontrado.");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar usuário no banco de dados: " + e.getMessage());
        }
        return usuario;
    }

	public void adicionarLivro(Livro livro) {
		try {
			String sql = "INSERT INTO livros (titulo, autor, disponivel) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, livro.getTitulo());
			statement.setString(2, livro.getAutor());
			statement.setBoolean(3, livro.isDisponibilidade());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar livro: " + e.getMessage());
		}
	}
	
	public void atualizarLivro(Livro livro) {
        try {
            String sql = "UPDATE livros SET titulo = ?, autor = ?, disponivel = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setBoolean(3, livro.isDisponibilidade());
            stmt.setInt(4, livro.getId());
            stmt.executeUpdate();
            System.out.println("Livro atualizado com sucesso no banco de dados.");
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar livro no banco de dados: " + e.getMessage());
        }
    }

	public void removerLivro(int livroId) {
		try {
			String sql = "DELETE FROM livros WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, livroId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Erro ao remover livro: " + e.getMessage());
		}
	}

	public Livro pesquisarLivro(int livroId) {
		Livro livro = null;
		try {
			String sql = "SELECT * FROM livros WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, livroId);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				livro = new Livro();
				livro.setId(result.getInt("id"));
				livro.setTitulo(result.getString("titulo"));
				livro.setAutor(result.getString("autor"));
				livro.setDisponibilidade(result.getBoolean("disponivel"));
			}
			statement.close();
			result.close();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar livro: " + e.getMessage());
		}
		return livro;
	}

	public List<Livro> exibirLivrosDisponiveis() {
		List<Livro> livros = new ArrayList<>();
		try {
			String sql = "SELECT * FROM livros WHERE disponivel = true";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				Livro livro = new Livro();
				livro.setId(result.getInt("id"));
				livro.setTitulo(result.getString("titulo"));
				livro.setAutor(result.getString("autor"));
				livro.setDisponibilidade(result.getBoolean("disponivel"));
				livros.add(livro);
			}
			statement.close();
			result.close();
		} catch (SQLException e) {
			System.out.println("Erro ao exibir livros disponíveis: " + e.getMessage());
		}
		return livros;
	}

}
