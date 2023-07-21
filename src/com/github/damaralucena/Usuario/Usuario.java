package com.github.damaralucena.Usuario;

import java.util.ArrayList;
import java.util.List;

import com.github.damaralucena.Livro.Livro;

public class Usuario {
	private int id;
	private String nome;
	private String cpf;
	private String senha;
	private String endereço;
	private List<Livro> listaLivrosEmprestados;
	
	public Usuario() {
		
	}
	
	public Usuario(int id, String nome, String cpf, String senha, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.endereço = endereco;
		this.listaLivrosEmprestados = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public void solicitarEmprestimo(Livro livro) {
        listaLivrosEmprestados.add(livro);
    }

    public void devolverLivro(Livro livro) {
        listaLivrosEmprestados.remove(livro);
    }

}
