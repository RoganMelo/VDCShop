package br.edu.flf.negocio;

import java.util.ArrayList;
import java.util.List;

import br.edu.flf.dao.DaoBluRay;
import br.edu.flf.entidades.BluRay;


public class NegocioBluRay {
	private DaoBluRay daoBluRay;
	
	public NegocioBluRay(DaoBluRay daoBluRay){
		this.daoBluRay = daoBluRay;
	}

	
	public void salvar(BluRay bluRay){
		daoBluRay.salvar(bluRay);
	}
	
	public void apagar(BluRay bluRay){
		daoBluRay.apagar(bluRay);
	
	}
	
	
	public void tiraDoEstoque(BluRay bluRay, int qtd){
		daoBluRay.decrementa(bluRay, qtd);
	}
	
	public void devolveAoEstoque(BluRay bluRay, int qtd){
		daoBluRay.incrementa(bluRay, qtd);
	}
	
	
	public BluRay buscar(BluRay bluRay){
		ArrayList <BluRay> bluRays = daoBluRay.procurar();
		if(!(bluRay==null))
			for (int i = 0; i < bluRays.size(); i++) {
				if (bluRay.getTitulo().equals(bluRays.get(i).getTitulo())){
					return bluRays.get(i);
				}
			}
		return null;
	}
	
	public void alterar(BluRay bluRay, BluRay bluRayAlterado){
		ArrayList <BluRay> bluRays = daoBluRay.procurar();
		if(!(bluRay==null))
			for (int i = 0; i < bluRays.size(); i++) {
				if (bluRay.getTitulo().equals(bluRays.get(i).getTitulo())){
					bluRays.remove(i);
					bluRays.add(i, bluRayAlterado);
				}
			}
		
	}
	
	public List<BluRay> listarTodos(){
		return daoBluRay.procurar();
		
	}
}
