package com.github.damaralucena.Livro;

import java.util.Date;

public class Livro {
	private int id;

	private String titulo;
	private String autor;
	private boolean disponibilidade;
	private Date dataEmprestimo;
	
	public Livro() {
		
	}

	public Livro(int id,String titulo, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.disponibilidade = true;
		this.dataEmprestimo = null;
	}

	public Livro(String titulo2, String autor2, boolean b) {
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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


}
