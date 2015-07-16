package br.edu.ifg.tads.jdbc.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Evento {
	
	private int idEvento;
	private String nomeEvento;
	private String descricao;
	private Calendar dataInicio;
	private Calendar dataEncerra;
	private String Organizador;
	private Endereco endereco = new Endereco();
	private Gerente gerente = new Gerente();
	private String email;
	private String telefone;
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDataEncerra() {
		return dataEncerra;
	}
	public void setDataEncerra(Calendar dataEncerra) {
		this.dataEncerra = dataEncerra;
	}
	public String getOrganizador() {
		return Organizador;
	}
	public void setOrganizador(String organizador) {
		Organizador = organizador;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	

}
