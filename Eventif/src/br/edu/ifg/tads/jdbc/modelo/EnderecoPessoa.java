package br.edu.ifg.tads.jdbc.modelo;

public class EnderecoPessoa {
	
	private int idEnderecoPessoa;
	private String numero;
	private String bairro;
	private String cep;
	private Cidade cidade = new Cidade();
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public int getIdEnderecoPessoa() {
		return idEnderecoPessoa;
	}
	public void setIdEnderecoPessoa(int idEnderecoPessoa) {
		this.idEnderecoPessoa = idEnderecoPessoa;
	}
	
	
	

}
