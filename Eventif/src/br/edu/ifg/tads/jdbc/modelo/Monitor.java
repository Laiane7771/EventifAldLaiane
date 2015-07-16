package br.edu.ifg.tads.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Monitor{
	
		private int idMonitor;
		private String matricula;
		private Pessoa pessoa = new Pessoa();
		private List<Atividade> listadeAtividades = new ArrayList<Atividade>();
		
		
		public int getIdMonitor() {
			return idMonitor;
		}
		public void setIdMonitor(int idMonitor) {
			this.idMonitor = idMonitor;
		}
		public String getMatricula() {
			return matricula;
		}
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
		public Pessoa getPessoa() {
			return pessoa;
		}
		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}
		public List<Atividade> getListadeAtividades() {
			return listadeAtividades;
		}
		public void setListadeAtividades(List<Atividade> listadeAtividades) {
			this.listadeAtividades = listadeAtividades;
		}
		
		
		
	
		
		
}
