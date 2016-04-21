package br.edu.flf.negocio;

import java.util.ArrayList;
import java.util.List;

import br.edu.flf.dao.DaoCd;
import br.edu.flf.entidades.Cd;



public class NegocioCd {
	private DaoCd daoCd;
	
	public NegocioCd(DaoCd daoCd){
		this.daoCd = daoCd;
	}
	
	public void salvar(Cd cd){
		daoCd.salvar(cd);
	}
	
	public void apagar(Cd cd){
		daoCd.apagar(cd);
	
	}
	
	
	public void tiraDoEstoque(Cd cd, int qtd){
		daoCd.decrementa(cd, qtd);
	}
	
	public void devolveAoEstoque(Cd cd, int qtd){
		daoCd.incrementa(cd, qtd);
	}
	
	
	public Cd buscar(Cd cd){
		ArrayList <Cd> cds = daoCd.procurar();
		if(!(cd==null))
			for (int i = 0; i < cds.size(); i++) {
				if (cd.getTitulo().equals(cds.get(i).getTitulo())){
					return cds.get(i);
				}
			}
		return null;
	}
	
	public void alterar(Cd cd, Cd cdAlterado){
		ArrayList <Cd> cds = daoCd.procurar();
		if(!(cd==null))
			for (int i = 0; i < cds.size(); i++) {
				if (cd.getTitulo().equals(cds.get(i).getTitulo())){
					cds.remove(i);
					cds.add(i, cdAlterado);
				}
			}
		
	}
	
	public List<Cd> listarTodos(){
		return daoCd.procurar();
		
	}
	

}
