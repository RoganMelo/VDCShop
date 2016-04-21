package br.edu.flf.negocio;

import java.util.ArrayList;
import java.util.List;

import br.edu.flf.dao.DaoCliente;
import br.edu.flf.entidades.Cliente;

public class NegocioCliente {
	private DaoCliente daoCliente;
	
	public NegocioCliente(DaoCliente daoCliente){
		this.daoCliente = daoCliente;
	}
	
	public void salvar(Cliente cliente){
		daoCliente.salvar(cliente);
	}
	
	public void apagar(Cliente cliente){
		daoCliente.apagar(cliente);
	
	}
	
	public Cliente buscar(Cliente cliente) {
		ArrayList <Cliente> clientes = daoCliente.procurar();
		if(!(cliente==null))
			for (int i = 0; i < clientes.size(); i++) {
				if (cliente.getNome().equals(clientes.get(i).getNome())){
					return clientes.get(i);
				}
			}
		return null;
		
	}
	
	public Cliente logar(Cliente cliente){
		ArrayList <Cliente> clientes = daoCliente.procurar();
		if(cliente!=null){
			for(int i=0; i<=clientes.size(); i++){
				if(cliente.getNome().equals(clientes.get(i).getNome())){
					return clientes.get(i);
				}
			}
			
			
		}
		return null;
		
	}
	
	public void alterar(Cliente cliente, Cliente clienteEditado){
		ArrayList <Cliente> clientes = daoCliente.procurar();
		if(!(cliente==null))
			for (int i = 0; i < clientes.size(); i++) {
				if (cliente.getNome().equals(clientes.get(i).getNome())){
					clientes.remove(i);
					clientes.add(i, clienteEditado);
				}
			}
		
	}
	
	public List<Cliente> listarTodos(){
		return daoCliente.procurar();
		
	}

}
