package br.edu.ifg.tads.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;

import br.edu.ifg.tads.jdbc.bd.ConnectionFactory;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Presenca;

public class PresencaDao {


	public Participante buscaPessoaPorCPF(Participante	participante){
		String sql = "SELECT pessoa.cpf, pessoa.senha, participante.idParticipante FROM pessoa" +
				" INNER JOIN participante ON pessoa.idPessoa = participante.idPessoa where pessoa.cpf=?";
		Participante p = null;
		Connection con = null;
		try{
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, participante.getPessoa().getCpf());
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				p = new Participante();
				p.getPessoa().setCpf(rs.getString("cpf"));
				p.setIdParticipante(rs.getInt("idParticipante"));

			}

		} catch (Exception e) {
			throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão: " +e.getMessage());
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("não foi possível fechar a conexão com o BD");
			}
		}
		return p;
	}



	public Participante MonitorbuscaparticipantenaAtividade(Participante participante, Atividade idAtividade){
		String sql = "select distinct pessoa.cpf FROM pessoa "+ 
				"INNER JOIN participante ON  pessoa.idPessoa = participante.idPessoa "+
				"INNER JOIN participaativi ON participante.idParticipante = participaativi.idParticipante "+
				"INNER JOIN atividade ON atividade.idAtividade = participaativi.idAtividade "+
				"WHERE atividade.idAtividade =" + idAtividade;

		Participante p = null;
		Connection con = null;
		try{
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, participante.getPessoa().getCpf());
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				p = new Participante();
				p.getPessoa().setCpf(rs.getString("cpf"));

			}

		} catch (Exception e) {
			throw new RuntimeException("Falha ao tentar executar um comando no BD. Verifique sua conexão");
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("Não foi possível fechar a conexão com o BD");
			}
		}
		return p;
		
	}
	public void insira(Presenca presenca, int idParticipante, int idAtividade){
		
		Connection con = null;
		
		try{
			
			String sql = "insert into presenca(horaEntrada,horaSaida,idParticipante,idAtividade)"
					+ "values(?,?,?,?)";
			
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			/*
			stmt.setTime(1, new Time(
					presenca.getHora_entrada().getInstance().HOUR_OF_DAY));
					//presenca.getHora_entrada().getTimeInMillis()));
			System.out.println(presenca.getHora_entrada().getTimeInMillis());
			stmt.setTime(2, new Time(
					
					presenca.getHora_entrada().getTime()));
					*/
			stmt.setInt(3, idParticipante);
			stmt.setInt(4, idAtividade);
			
			stmt.executeUpdate();
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
	         throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão");
	     }finally{
	    	 try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("não foi possível fechar a conexão com o BD");
			}
	     }
	 }
	
	public void insiraEntrada(	Presenca presenca,Participante participante, Atividade atividade){
	     /*
		ParticipanteDao pd = new ParticipanteDao();
		Participante p = new Participante();
		p.setIdParticipante(idParticipante);
		p = pd.buscaParticipanteporID(p);
	
		/*
		ParticipanteDao pdao = new ParticipanteDao();
		int idPaticipante = presenca.getParticipante().getIdParticipante();
		
		AtividadeDao adao = new AtividadeDao();
		int idAtividade = presenca.getAtividade().getIdAtividade();
		
		*/
        
		
		Connection con = null;
		
		try{
		
			
			String sql = "insert into presenca(hora_entrada,idParticipante,idAtividade)"
					+ "values(?,?,?)";
			
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			/*
			stmt.setTime(1, new Time(
					presenca.getHora_entrada().getTime()));
					*/
			Calendar c = Calendar.getInstance();
			
			stmt.setTime(1, new Time(c.getTime().getTime()));
			
			
						
			stmt.setInt(2,participante.getIdParticipante());
			stmt.setInt(3,atividade.getIdAtividade());
			
			stmt.executeUpdate();
		 } catch (Exception e) {
			 //System.out.println(e.getMessage());
	         throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão"+e.getMessage());
	     }finally{
	    	 try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("não foi possível fechar a conexão com o BD");
			}
	     }
	 }
		public void insiraSaida(Presenca presenca,Participante participante, Atividade atividade){
			/*
			ParticipanteDao pdao = new ParticipanteDao();
			int idPaticipante = presenca.getParticipante().getIdParticipante();
			
			AtividadeDao adao = new AtividadeDao();
			int idAtividade = presenca.getAtividade().getIdAtividade();
		*/
		Connection con = null;
		
		try{
			
			String sql = "insert into presenca(hora_saida,idParticipante,idAtividade)"
					+ "values(?,?,?)";
			
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			Calendar c = Calendar.getInstance();
			
			stmt.setTime(1, new Time(c.getTime().getTime()));
			
			
			stmt.setInt(2,participante.getIdParticipante());
			stmt.setInt(3,atividade.getIdAtividade());
			
			stmt.executeUpdate();
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
	         throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão");
	     }finally{
	    	 try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("não foi possível fechar a conexão com o BD");
			}
	     }
	 }
}




