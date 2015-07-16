package br.edu.ifg.tads.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifg.tads.jdbc.bd.ConnectionFactory;
import br.edu.ifg.tads.jdbc.modelo.Cracha;


public class CrachaDao {

	public List<Cracha> buscaDadosParaCracha(int idParticipante){

		try {
			List<Cracha> linha = new ArrayList<Cracha>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement ("SELECT DISTINCT pessoa.nomePessoa, pessoa.cpf FROM pessoa " +
							"INNER JOIN participante ON pessoa.idPessoa = participante.idPessoa "+
							"WHERE participante.idParticipante = "+ idParticipante);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Crachá
				Cracha cr = new Cracha();
				cr.setNomePessoa(rs.getString("nomePessoa"));
				cr.setCpf(rs.getString("cpf"));

				linha.add(cr);

			}
			rs.close();
			stmt.close();
			return linha;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<Cracha> buscaDadosParaTodosCracha(){

		try {
			List<Cracha> linha = new ArrayList<Cracha>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement ("SELECT DISTINCT pessoa.nomePessoa, pessoa.cpf FROM pessoa " +
							"INNER JOIN participante ON pessoa.idPessoa = participante.idPessoa " +
							"INNER JOIN participaativi ON participante.idParticipante = participaativi.idParticipante " +
							"INNER JOIN atividade ON atividade.idAtividade = participaativi.idAtividade");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Crachá
				Cracha cr = new Cracha();
				cr.setNomePessoa(rs.getString("nomePessoa"));
				cr.setCpf(rs.getString("cpf"));

				linha.add(cr);
			}
			rs.close();
			stmt.close();
			return linha;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
