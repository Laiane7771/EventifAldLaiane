package br.edu.ifg.tads.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;


public class CertificadoEvento {
	
	private int idParticipantes;
	private String nomePessoa;
	private String nomeEvento;
	private String dataInicio;
	private String dataEncerra;
	private List<AtividadeCertificado> list= new ArrayList<AtividadeCertificado>();
	
	
	
	public int getIdParticipantes() {
		return idParticipantes;
	}
	public void setIdParticipantes(int idParticipantes) {
		this.idParticipantes = idParticipantes;
	}
	public List<AtividadeCertificado> getList() {
		return list;
	}
	public void setList(List<AtividadeCertificado> list) {
		this.list = list;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataEncerra() {
		return dataEncerra;
	}
	public void setDataEncerra(String dataEncerra) {
		this.dataEncerra = dataEncerra;
	}
	
	

}
