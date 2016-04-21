package br.edu.flf.entidades;

public class Cd extends Produto {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (duplo ? 1231 : 1237);
		result = prime * result + quantidade_faixas;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cd other = (Cd) obj;
		if (duplo != other.duplo)
			return false;
		if (quantidade_faixas != other.quantidade_faixas)
			return false;
		return true;
	}
	private boolean duplo;
	private int quantidade_faixas;
	public boolean isDuplo() {
		return duplo;
	}
	public void setDuplo(boolean duplo) {
		this.duplo = duplo;
	}
	public int getQuantidade_faixas() {
		return quantidade_faixas;
	}
	public void setQuantidade_faixas(int quantidade_faixas) {
		this.quantidade_faixas = quantidade_faixas;
	}
}
