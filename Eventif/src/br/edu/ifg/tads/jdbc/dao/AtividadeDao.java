package br.edu.ifg.tads.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.Vector;

import br.edu.ifg.tads.jdbc.bd.ConnectionFactory;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.modelo.Monitor;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.TipoAtivi;

public class AtividadeDao {

	
	public void insereMonitorAtivi(int idParticipante,  int idAtividade){

		ParticipanteDao pd = new ParticipanteDao();
		Participante p = new Participante();
		p.setIdParticipante(idParticipante);
		p = pd.buscaParticipanteporID(p);
		MonitorDao md = new MonitorDao();
		int idMonitor = md.inserir(p);

		Connection con = null;

		try{
			String sql = "insert into MonitorAtividade"+
					"(idMonitor, idAtividade) values(?,?)";

			con = new ConnectionFactory().getConnection();
			//Atividade at = it.next();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, idMonitor);
			stmt.setInt(2, idAtividade);

			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Falha ao tentar executar um comando no BD. Verifique sua conexão");
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("Não foi possÃ­vel fechar a conexão com o BD");
			}
		}
	}



	public void insereAtividadeParticipante(Participante participante, Atividade atividade){
		Connection con = null;

		try{
			String sql = "insert into ParticipaAtivi"+
					"(idParticipante, idAtividade) values(?,?)";

			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, participante.getIdParticipante());
			stmt.setInt(2, atividade.getIdAtividade());

			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Falha ao tentar executar um comando no BD. Verifique sua conexão");
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("Não foi possÃ­vel fechar a conexão com o BD");
			}
		}
	}


	public void insere(Atividade atividade){

		EventoDao tAO = new EventoDao();
		int idEvento = atividade.getEvento().getIdEvento();
		Connection con = null;

		try{
			String sql = "insert into tipoativi"+
					"(tipoatividade) values(?)";

			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, atividade.getTipoativi().getTipoAtividade());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			int idtipoativi = 0;
			if(rs.next()){
				idtipoativi = rs.getInt("idtipoativi");
			}

			String sql1 = "insert into Atividade(nomeAtividade,descricaoAt,ministrante, data, horainicio,horaencerra, numeroVagas, "
					+ " idtipoativi, idEvento) values(?,?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, atividade.getNomeAtividade());
			stmt.setString(2, atividade.getDescricaoAt());
			stmt.setString(3, atividade.getMinistrante());
			stmt.setDate(4, new Date(atividade.getData().getTime().getTime()));
			stmt.setTime(5, atividade.getHoraInicio());
			stmt.setTime(6, atividade.getHoraEncerra());
			stmt.setInt(7, atividade.getNumeroVagas());
			stmt.setInt(8, idtipoativi);
			stmt.setInt(9,idEvento );
			stmt.executeUpdate();

			System.out.println(stmt.getWarnings());

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

	public Vector<Vector<String>> buscaAtividades(int id){

		try {
			Vector<Vector<String>> atividades = new Vector<Vector<String>>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement ("SELECT evento.nomeEvento, atividade.nomeAtividade, atividade.idAtividade, atividade.numeroVagas FROM evento" +
							" INNER JOIN atividade ON atividade.idEvento = evento.idEvento where evento.idEvento = "+id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Monitor

				Atividade a = new Atividade();
				Evento e = new Evento();
				a.setIdAtividade(rs.getInt("idAtividade"));
				e.setNomeEvento(rs.getString("nomeEvento"));
				a.setNomeAtividade(rs.getString("nomeAtividade"));
				a.setNumeroVagas(rs.getInt("numeroVagas"));


				Vector<String> colunas = new Vector<String>();
				colunas.add("" + a.getIdAtividade());
				colunas.add(e.getNomeEvento());
				colunas.add(a.getNomeAtividade());
				colunas.add(""+ a.getNumeroVagas());

				// adicionando o objeto à lista
				atividades.add(colunas);
			}
			rs.close();
			stmt.close();
			return atividades;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Vector<Vector<String>> buscaAtividadeNome(Atividade atividade){
		try{
			Vector<Vector<String>> atividades = new Vector<Vector<String>>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement("Select atividade.idAtividade, evento.nomeEvento, atividade.nomeAtividade,atividade.numeroVagas from atividade " +
							"INNER JOIN evento ON evento.idEvento = atividade.idEvento " +
							"where atividade.nomeAtividade like '%"+atividade.getNomeAtividade()+"%'");

			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				//criando o objeto Participante
				Atividade a = new Atividade();
				Evento e = new Evento();
				a.setIdAtividade(rs.getInt("idAtividade"));
				e.setNomeEvento(rs.getString("nomeEvento"));
				a.setNomeAtividade(rs.getString("nomeAtividade"));
				a.setNumeroVagas(rs.getInt("numeroVagas"));

				Vector<String> colunas = new Vector<String>();
				colunas.add(""+a.getIdAtividade());
				colunas.add(e.getNomeEvento());
				colunas.add(a.getNomeAtividade());
				colunas.add(""+a.getNumeroVagas());
				atividades.add(colunas);
			}
			rs.close();
			stmt.close();
			return atividades;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void alteraTipoAtividade(TipoAtivi tipoAtivi){


		String sql = "Update tipoativi set tipoatividade = ? where tipoativi = ?";

		try{
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement(sql);
			stmt.setString(1, tipoAtivi.getTipoAtividade());
			stmt.setInt(2, tipoAtivi.getIdtipoativi());
			System.out.println(stmt.toString());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}


	public void alteraAtividade(Atividade atividade){
		String sql = "Update atividade set nomeAtividade=?,descricaoAt=?, ministrante=?, horaInicio=?, horaencerra=?, data=?, numeroVagas=? where idAtividade =?";

		try{
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement(sql);
			stmt.setString(1, atividade.getNomeAtividade());
			stmt.setString(2, atividade.getDescricaoAt());
			stmt.setString(3, atividade.getMinistrante());

			stmt.setDate(4, new Date(atividade.getData()
					.getTimeInMillis()));

			stmt.setTime(5, new Time(atividade.getHoraInicio()
					.getTime()));
			stmt.setTime(6,  new Time(atividade.getHoraEncerra()
					.getTime()));
			stmt.setInt(7, atividade.getCargahoraria());

			stmt.setInt(5, atividade.getNumeroVagas());
			stmt.setInt(6, atividade.getIdAtividade());
			System.out.println(stmt.toString());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}

	public Atividade buscaAtividade(Atividade a){
		System.out.println(a.getIdAtividade());
		Atividade atividade = new Atividade();
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement("select * from atividade inner join tipoativi "
							+ "on atividade.idTipoativi = tipoativi.idTipoativi "
							+ " where idAtividade = "+a.getIdAtividade());
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				atividade.setIdAtividade(rs.getInt("idAtividade"));
				atividade.setNomeAtividade(rs.getString("nomeAtividade"));
				atividade.setDescricaoAt(rs.getString("descricaoat"));
				atividade.setMinistrante(rs.getString("ministrante"));
				atividade.getTipoativi().setTipoAtividade(rs.getString("tipoAtividade"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				atividade.setData(data);

				atividade.setHoraInicio(rs.getTime("horaInicio"));
				atividade.setHoraEncerra(rs.getTime("horaEncerra"));
				atividade.setCargahoraria(rs.getInt("cargaHoraria"));
				atividade.setNumeroVagas(rs.getInt("numeroVagas"));

			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return atividade;
	}
	public void removeAtividade(Atividade atividade) {
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("delete from atividade where idAtividade=?");
			stmt.setInt(1, atividade.getIdAtividade());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}