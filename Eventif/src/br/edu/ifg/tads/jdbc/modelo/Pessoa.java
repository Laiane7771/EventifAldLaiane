package br.edu.ifg.tads.jdbc.modelo;

public class Pessoa {
	
	private int idPessoa;
	private String cpf;
	private String rg;
	private String nomePessoa;
	private String senha;
	private EnderecoPessoa enderecopessoa  = new EnderecoPessoa(); 
	private ContatoPessoa contatopessoa = new ContatoPessoa();

	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public EnderecoPessoa getEnderecopessoa() {
		return enderecopessoa;
	}
	public void setEnderecopessoa(EnderecoPessoa enderecopessoa) {
		this.enderecopessoa = enderecopessoa;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public ContatoPessoa getContatopessoa() {
		return contatopessoa;
	}
	public void setContatopessoa(ContatoPessoa contatopessoa) {
		this.contatopessoa = contatopessoa;
	}
	
	
	

}
