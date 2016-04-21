package br.edu.flf.entidades;

import java.util.ArrayList;

public class Pedido {

	// sem carrinho, sera feito dentro do Pedido
	private FormaDePagamento forma;
	private Cliente cliente;
	private Double total;
	private ArrayList<Produto> produtos;
	private int id;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void calculaTotal(){
		total=0.00;
		for(Produto produto : produtos){
			total += (produto.getPreco() * produto.getQuantidade());
		}
	}
	
	public void adicionarAoCarrinho(Produto prod){
		produtos.add(prod);
	}
	
	
	@Override
	public String toString() {
		return "Produtos: " + produtos;
	}
	public FormaDePagamento getForma() {
		return forma;
	}
	public void setForma(FormaDePagamento forma) {
		this.forma = forma;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getTotal() {
		calculaTotal();
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
