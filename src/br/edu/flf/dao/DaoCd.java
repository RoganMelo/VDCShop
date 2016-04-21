package br.edu.flf.dao;

import java.util.ArrayList;

import br.edu.flf.entidades.Cd;

public class DaoCd {
private ArrayList<Cd> cds = new ArrayList<Cd>();

public void salvar(Cd cd){
	cds.add(cd);
	
}

public void apagar(Cd cd){
	for (int i = 0; i < cds.size(); i++)
		if (cds.get(i).equals(cd)) {
			cds.remove(i);
		}
}

public void decrementa(Cd cd, int qtd){
	for (int i = 0; i < cds.size(); i++)
		if (cds.get(i).getTitulo().equals(cd.getTitulo())) {
			cds.get(i).setQuantidade(cds.get(i).getQuantidade() - qtd);;
		}
}


public void incrementa(Cd cd, int qtd){
	for (int i = 0; i < cds.size(); i++)
		if (cds.get(i).getTitulo().equals(cd.getTitulo())) {
			cds.get(i).setQuantidade(cds.get(i).getQuantidade() + qtd);;
		}
}



public ArrayList<Cd> procurar() {
	return cds;
}

}
