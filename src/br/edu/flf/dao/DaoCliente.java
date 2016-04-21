package br.edu.flf.dao;

import java.util.ArrayList;

import br.edu.flf.entidades.Cliente;

public class DaoCliente {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public void salvar(Cliente cliente){
		clientes.add(cliente);
		
	}

	public void apagar(Cliente cliente){
		for (int i = 0; i < clientes.size(); i++)
			if (clientes.get(i).equals(cliente)) {
				clientes.remove(i);
			}
	}

	public ArrayList<Cliente> procurar() {
		return clientes;
	}


}
