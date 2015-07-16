package br.edu.ifg.tads.jdbc.modelo;

import java.sql.Time;
import java.util.Calendar;

public class Presenca {
	private int idPresenca;
	private Time Hora_entrada;
	private Time hora_saida;
	private Atividade atividade;
	private Participante participante = new Participante();
	
	public int getIdPresenca() {
		return idPresenca;
	}
	public void setIdPresenca(int idPresenca) {
		this.idPresenca = idPresenca;
	}
	
	public Time getHora_entrada() {
		return Hora_entrada;
	}
	public void setHora_entrada(Time hora_entrada) {
		Hora_entrada = hora_entrada;
	}
	public Time getHora_saida() {
		return hora_saida;
	}
	public void setHora_saida(Time hora_saida) {
		this.hora_saida = hora_saida;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public Participante getParticipante() {
		return participante;
	}
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	

}
