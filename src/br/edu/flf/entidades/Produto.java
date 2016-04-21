package br.edu.flf.entidades;

public abstract class Produto {
	@Override
	public String toString() {
		return quantidade+ "x " + titulo;
	}

	private String titulo;
	private double preco;
	private int quantidade;
	private String data_de_publicacao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getData_de_publicacao() {
		return data_de_publicacao;
	}

	public void setData_de_publicacao(String data_de_publicacao) {
		this.data_de_publicacao = data_de_publicacao;
	}
}
