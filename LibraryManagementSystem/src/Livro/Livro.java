package Livro;

public class Livro {
	private String titulo;
	private String autor;
	private boolean disponibilidade;

	public Livro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.disponibilidade = true;
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
