package br.edu.ifg.tads.jdbc.modelo;

public class Gerente {
	
	private int idGerente;
	private String matriculaSiape;
	private Pessoa pessoa = new Pessoa();
	
	public int getIdGerente() {
		return idGerente;
	}
	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
	}
	public String getMatriculaSiape() {
		return matriculaSiape;
	}
	public void setMatriculaSiape(String matriculaSiape) {
		this.matriculaSiape = matriculaSiape;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
