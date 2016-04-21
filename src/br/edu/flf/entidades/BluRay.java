package br.edu.flf.entidades;

public class BluRay extends Produto{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (duplo ? 1231 : 1237);
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
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
		BluRay other = (BluRay) obj;
		if (duplo != other.duplo)
			return false;
		if (tema != other.tema)
			return false;
		return true;
	}
	private boolean duplo;
	private Tema tema;
	public boolean isDuplo() {
		return duplo;
	}
	public void setDuplo(boolean duplo) {
		this.duplo = duplo;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	

}
