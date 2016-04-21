package br.edu.flf.negocio;

import java.util.ArrayList;
import java.util.List;

import br.edu.flf.dao.DaoLivro;
import br.edu.flf.entidades.Livro;

public class NegocioLivro {
	private DaoLivro daoLivro;
	
	public NegocioLivro(DaoLivro daoLivro){
		this.daoLivro = daoLivro;
	}
	
	public void salvar(Livro livro){
		daoLivro.salvar(livro);
	}
	
	public void apagar(Livro livro){
		daoLivro.apagar(livro);
	
	}
	
	
	public void tiraDoEstoque(Livro livro, int qtd){
		daoLivro.decrementa(livro, qtd);
	}
	
	public void devolveAoEstoque(Livro livro, int qtd){
		daoLivro.incrementa(livro, qtd);
	}
	
	
	public Livro buscar(Livro livro) {
		ArrayList <Livro> livros = daoLivro.procurar();
		if(!(livro==null))
			for (int i = 0; i < livros.size(); i++) {
				if (livro.getTitulo().equals(livros.get(i).getTitulo())){
					return livros.get(i);
				}
			}
		return null;
		
	}
	
	public void alterar(Livro livro, Livro livroEditado){
		ArrayList <Livro> livros = daoLivro.procurar();
		if(!(livro==null))
			for (int i = 0; i < livros.size(); i++) {
				if (livro.getTitulo().equals(livros.get(i).getTitulo())){
					livros.remove(i);
					livros.add(i, livroEditado);
				}
			}
	}
	
	public List<Livro> listarTodos(){
		return daoLivro.procurar();
		
	}
	
}
