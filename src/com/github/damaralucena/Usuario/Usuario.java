package com.github.damaralucena.Usuario;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.github.damaralucena.Livro.Livro;

public class Usuario {
	private String nome;
	private String cpf;
	private String senha;
	private String endereço;
	private List<Livro> listaLivrosEmprestados;
	
	public Usuario(String nome, String cpf, String senha, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.endereço = endereco;
		this.listaLivrosEmprestados = new ArrayList<Livro>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public List<Livro> getListaLivrosEmprestados() {
		return listaLivrosEmprestados;
	}
	
	public void criarUsuario(String nome, String senha, String endereco, String cpf) {
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.endereço = endereco;
		System.out.println("Usuário criador com sucesso!");

	}

	public void solicitarEmprestimo(Livro livro) {
		
		if (livro.isDisponibilidade()) {
			listaLivrosEmprestados.add(livro);
			livro.setDisponibilidade(false);
			livro.setDataEmprestimo(new Date());
			System.out.println("Empréstimo realizado!");
		} else {
			System.out.println("Livro indisponível.");
		}
	}

	public void devolverLivro(Livro livro) {
		if (listaLivrosEmprestados.contains(livro)) {
			listaLivrosEmprestados.remove(livro);
			livro.setDisponibilidade(true);
			livro.setDataEmprestimo(null);
		} else {
			System.out.println("Você não possui este livro na sua lista de emprestimo!.");
		}
	}
	
	public Livro buscarLivroEmprestado(String titulo) {
		for (Livro livro : listaLivrosEmprestados) {
			if (livro.getTitulo().equalsIgnoreCase(titulo)) {
				return livro;
			}
		}
		
		return null;
	}
	
	public void exibirLivrosEmprestados() {
		System.out.println("Livros emprestados: ");
		System.out.println("");
		for (Livro livro : listaLivrosEmprestados) {
			System.out.println("Título: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor());
		}
	}

}
