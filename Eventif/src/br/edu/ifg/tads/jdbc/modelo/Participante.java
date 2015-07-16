package br.edu.ifg.tads.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Participante{
	
	private int idParticipante;
	private String matricula;
	private Pessoa pessoa = new Pessoa();
	private List<Atividade> listaAtividade = new ArrayList<Atividade>();
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}

	public List<Atividade> getListaAtividade() {
		return listaAtividade;
	}

	public void setListaAtividade(List<Atividade> listaAtividade) {
		this.listaAtividade = listaAtividade;
	}
	
	
	
}
