package br.edu.flf.dao;

import java.util.ArrayList;

import br.edu.flf.entidades.BluRay;

public class DaoBluRay {
	private ArrayList<BluRay> bluRays = new ArrayList<BluRay>();

	public void salvar(BluRay bluRay){
		bluRays.add(bluRay);
		
	}
	
	
	public void decrementa(BluRay bluRay, int qtd){
		for (int i = 0; i < bluRays.size(); i++)
			if (bluRays.get(i).getTitulo().equals(bluRay.getTitulo())) {
				bluRays.get(i).setQuantidade(bluRays.get(i).getQuantidade() - qtd);;
			}
	}
	
	
	public void incrementa(BluRay bluRay, int qtd){
		for (int i = 0; i < bluRays.size(); i++)
			if (bluRays.get(i).getTitulo().equals(bluRay.getTitulo())) {
				bluRays.get(i).setQuantidade(bluRays.get(i).getQuantidade() + qtd);;
			}
	}
	
	
	

	public void apagar(BluRay bluRay){
		for (int i = 0; i < bluRays.size(); i++)
			if (bluRays.get(i).equals(bluRay)) {
				bluRays.remove(i);
			}
	}

	public ArrayList<BluRay> procurar() {
		return bluRays;
	}

}
