package com.github.damaralucena.Livro;

import java.util.Date;

public class Livro {
	private String titulo;
	private String autor;
	private boolean disponibilidade;
	private Date dataEmprestimo;

	public Livro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.disponibilidade = true;
		this.dataEmprestimo = null;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public void obterInformacaoLivros() {
		System.out.println("Título: " + this.titulo);
		System.out.println("Autor: " + this.autor);
		System.out.println("Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível"));
	}

	public void alterarStatusDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;

		System.out.println(
				"Status de disponibilidade alterado para: " + (disponibilidade ? "Disponível" : "Indisponível"));
	}

}
