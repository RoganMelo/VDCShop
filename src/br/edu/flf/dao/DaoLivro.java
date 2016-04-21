package br.edu.flf.dao;

import java.util.ArrayList;

import br.edu.flf.entidades.Livro;

public class DaoLivro {

	private ArrayList<Livro> livros = new ArrayList<Livro>(); 
	
	public void salvar(Livro livro){
		livros.add(livro);
		
	}
	
	
	public void decrementa(Livro livro, int qtd){
		for (int i = 0; i < livros.size(); i++)
			if (livros.get(i).getTitulo().equals(livro.getTitulo())) {
				livros.get(i).setQuantidade(livros.get(i).getQuantidade() - qtd);;
			}
	}

	
	public void incrementa(Livro livro, int qtd){
		for (int i = 0; i < livros.size(); i++)
			if (livros.get(i).getTitulo().equals(livro.getTitulo())) {
				livros.get(i).setQuantidade(livros.get(i).getQuantidade() + qtd);;
			}
	}
	
	
	
	public void apagar(Livro livro){
		for (int i = 0; i < livros.size(); i++)
			if (livros.get(i).equals(livro)) {
				livros.remove(i);
			}
	}
	
	public ArrayList<Livro> procurar() {
		return livros;
	}
	
	
}
