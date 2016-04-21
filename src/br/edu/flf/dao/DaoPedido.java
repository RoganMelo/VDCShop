package br.edu.flf.dao;

import java.util.ArrayList;

import br.edu.flf.entidades.Pedido;

public class DaoPedido {
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public void salvar(Pedido pedido){
		pedidos.add(pedido);
		
	}

	public void apagar(Pedido pedido){
		for (int i = 0; i < pedidos.size(); i++)
			if (pedidos.get(i).equals(pedido)) {
				pedidos.remove(i);
			}
	}

	public ArrayList<Pedido> procurar() {
		return pedidos;
	}

}
