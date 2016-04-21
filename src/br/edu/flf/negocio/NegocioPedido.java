package br.edu.flf.negocio;

import java.util.ArrayList;
import java.util.List;

import br.edu.flf.dao.DaoBluRay;
import br.edu.flf.dao.DaoCd;
import br.edu.flf.dao.DaoLivro;
import br.edu.flf.dao.DaoPedido;
import br.edu.flf.entidades.BluRay;
import br.edu.flf.entidades.Cd;
import br.edu.flf.entidades.Cliente;
import br.edu.flf.entidades.Livro;
import br.edu.flf.entidades.Pedido;
import br.edu.flf.entidades.Produto;

public class NegocioPedido {
	private DaoPedido daoPedido;
	
	private NegocioLivro negocioLivro;
	private NegocioBluRay negocioBluRay;
	private NegocioCd negocioCd;
	
	
	
	public NegocioPedido(DaoPedido daoPedido){
		this.daoPedido = daoPedido;
	}
	
	
	public Pedido buscar(Pedido pedido){
		ArrayList<Pedido> pedidos = daoPedido.procurar();
		if(pedido!=null){
			for(int i=0; i< pedidos.size(); i++){
				if(pedido.getId() == pedidos.get(i).getId()){
					return pedidos.get(i);
				}
			}
		}
		return null;
	}
	
	
	public void salvar(Pedido pedido){
		ArrayList<Pedido> pedidos = daoPedido.procurar();
		if(pedidos.size() == 0){
			pedido.setId(1);
			daoPedido.salvar(pedido);
		}
		else {
			pedido.setId(pedidos.size() + 1);
			daoPedido.salvar(pedido);
		}
	}
	
	public void apagar(Pedido pedido){
		daoPedido.apagar(pedido);
	
	}
	
	
	public ArrayList<Produto> adcCarrinho(ArrayList<Produto> produtos, Produto produto){
		boolean taDentro = false;
		if(produto.getQuantidade() > 0){
			if(produtos != null){
				for(int i=0; i<produtos.size(); i++){
					if(produto.getClass() == produtos.get(i).getClass() && produto.getTitulo().equals(produtos.get(i).getTitulo())){
						taDentro = true;
						if(produto.getQuantidade() > produtos.get(i).getQuantidade()){
							produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() + 1);
							return produtos;
						}
					}
				
				}
				
				if(taDentro == false){
					produto.setQuantidade(1);
					produtos.add(produto);
					return produtos;
				}else{
					return produtos;
				}
			}
			
			
				
			}
		return produtos;	
	}
	
	
	public void tiraDoEstoque(ArrayList<Produto> produtos, DaoBluRay daoBluRay, DaoCd daoCd, DaoLivro daoLivro){
		negocioBluRay = new NegocioBluRay(daoBluRay);
		negocioCd = new NegocioCd(daoCd);
		negocioLivro = new NegocioLivro(daoLivro);
		
		for (int i=0;i < produtos.size(); i++){
			if(produtos.get(i) instanceof Cd){
				negocioCd.tiraDoEstoque((Cd) produtos.get(i), produtos.get(i).getQuantidade());
			}
			
			else if(produtos.get(i) instanceof Livro){
				negocioLivro.tiraDoEstoque((Livro) produtos.get(i), produtos.get(i).getQuantidade());
			}
			
			else if(produtos.get(i) instanceof BluRay){
				negocioBluRay.tiraDoEstoque((BluRay) produtos.get(i), produtos.get(i).getQuantidade());
			}
			
			
		}
				
	}
	
	
	public void devolveAoEstoque(ArrayList<Produto> produtos, DaoBluRay daoBluRay, DaoCd daoCd, DaoLivro daoLivro){
		negocioBluRay = new NegocioBluRay(daoBluRay);
		negocioCd = new NegocioCd(daoCd);
		negocioLivro = new NegocioLivro(daoLivro);
		
		for (int i=0;i < produtos.size(); i++){
			if(produtos.get(i) instanceof Cd){
				negocioCd.devolveAoEstoque((Cd) produtos.get(i), produtos.get(i).getQuantidade());
			}
			
			else if(produtos.get(i) instanceof Livro){
				negocioLivro.devolveAoEstoque((Livro) produtos.get(i), produtos.get(i).getQuantidade());
			}
			
			else if(produtos.get(i) instanceof BluRay){
				negocioBluRay.devolveAoEstoque((BluRay) produtos.get(i), produtos.get(i).getQuantidade());
			}
			
			
		}
		
		
	}
	
	
	
	
	
	public void adcCliente(Pedido pedido, Cliente cliente){
		pedido.setCliente(cliente);
	}
	
	
	public List<Pedido> listarTodos(){
		return daoPedido.procurar();
		
	}
}
