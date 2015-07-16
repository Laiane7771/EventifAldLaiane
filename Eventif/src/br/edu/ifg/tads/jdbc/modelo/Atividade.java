package br.edu.ifg.tads.jdbc.modelo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class Atividade {
	
	private int idAtividade;
	private String nomeAtividade;
	private String descricaoAt;
	private Calendar data;
	private String ministrante;
	private Time horaInicio;
	private Time horaEncerra;
	private int cargahoraria;
	private int numeroVagas;
	private TipoAtivi tipoativi = new TipoAtivi();
	private Evento evento = new Evento();
	
	public int getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
	public String getNomeAtividade() {
		return nomeAtividade;
	}
	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}
	public String getDescricaoAt() {
		return descricaoAt;
	}
	public void setDescricaoAt(String descricaoAt) {
		this.descricaoAt = descricaoAt;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getMinistrante() {
		return ministrante;
	}
	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
	}
	
	
	
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraEncerra() {
		return horaEncerra;
	}
	public void setHoraEncerra(Time horaEncerra) {
		this.horaEncerra = horaEncerra;
	}
	
	public int getCargahoraria() {
		return cargahoraria;
	}
	public void setCargahoraria(int cargahoraria) {
		this.cargahoraria = cargahoraria;
	}
	public int getNumeroVagas() {
		return numeroVagas;
	}
	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}
	public TipoAtivi getTipoativi() {
		return tipoativi;
	}
	public void setTipoativi(TipoAtivi tipoativi) {
		this.tipoativi = tipoativi;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
	

}
