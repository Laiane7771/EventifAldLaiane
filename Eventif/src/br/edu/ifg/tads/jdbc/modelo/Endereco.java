package br.edu.ifg.tads.jdbc.modelo;

public class Endereco {
	
	private int idEndereco;
	private String cep;
	private String numero;
	private String bairro;
	private String localDoEvento;
	private Cidade cidade = new Cidade();
	
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
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
	public String getLocalDoEvento() {
		return localDoEvento;
	}
	public void setLocalDoEvento(String localDoEvento) {
		this.localDoEvento = localDoEvento;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


}
