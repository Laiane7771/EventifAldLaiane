package br.edu.ifg.tads.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.functors.IfClosure;

import br.edu.ifg.tads.jdbc.bd.ConnectionFactory;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.AtividadeCertificado;
import br.edu.ifg.tads.jdbc.modelo.CertificadoEvento;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.modelo.Participante;

public class CertificadoDao {

	public List<CertificadoEvento> buscaDadosParaCertificado(int idParticipante){

		try {
			List<CertificadoEvento> linha = new ArrayList<CertificadoEvento>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement ("SELECT pessoa.nomePessoa, evento.nomeEvento, evento.dataInicio, evento.dataEncerra, atividade.nomeAtividade, atividade.cargahoraria FROM pessoa "+
							"INNER JOIN participante ON pessoa.idPessoa = participante.idPessoa "+
							"INNER JOIN participaAtivi ON participante.idParticipante = participaAtivi.idParticipante "+
							"INNER JOIN atividade ON atividade.idatividade = participaativi.idAtividade "+
							"INNER JOIN evento ON atividade.idEvento = evento.idEvento " +
							"WHERE participante.idParticipante = " + idParticipante);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Monitor

				Atividade atividade = new Atividade();
				Participante participante = new Participante();
				Evento evento = new Evento();
				participante.getPessoa().setNomePessoa(rs.getString("nomePessoa"));
				evento.setNomeEvento(rs.getString("nomeEvento"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataInicio"));
				evento.setDataInicio(data);
				Calendar data2 = Calendar.getInstance();
				data2.setTime(rs.getDate("dataEncerra"));
				evento.setDataEncerra(data2);
				//atividade.setNomeAtividade(rs.getString("nomeAtividade"));
				//atividade.setCargahoraria(rs.getInt("cargahoraria"));

				CertificadoEvento ce = new CertificadoEvento();
				
				ce.setNomePessoa(participante.getPessoa().getNomePessoa());
				ce.setNomeEvento(evento.getNomeEvento());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				ce.setDataInicio(sdf.format(evento.getDataInicio().getTime()));
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
				ce.setDataEncerra(sdf.format(evento.getDataEncerra().getTime()));
				//linha.add(atividade.getNomeAtividade());
				//linha.add(""+atividade.getCargahoraria());
				linha.add(ce);

			}
			rs.close();
			stmt.close();
			return linha;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<CertificadoEvento> buscaDadosParaTodosCertificado(int idEvento){

		try {
			List<CertificadoEvento> linha = new ArrayList<CertificadoEvento>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement ("SELECT distinct participante.idParticipante, pessoa.nomePessoa, evento.nomeEvento, evento.dataInicio, evento.dataEncerra, atividade.nomeAtividade, atividade.cargahoraria FROM pessoa "+
							"INNER JOIN participante ON pessoa.idPessoa = participante.idPessoa "+
							"INNER JOIN participaAtivi ON participante.idParticipante = participaAtivi.idParticipante "+
							"INNER JOIN atividade ON atividade.idatividade = participaativi.idAtividade "+
							"INNER JOIN evento ON atividade.idEvento = evento.idEvento where evento.idEvento = " + idEvento); 

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Monitor

				AtividadeCertificado atividade = new AtividadeCertificado();
				
				Participante participante = new Participante();
				Evento evento = new Evento();
				participante.setIdParticipante(rs.getInt("idParticipante"));
				boolean participanteExiste = false;
				int participanteId = 0;
				Iterator<CertificadoEvento> it = linha.iterator();
				while(it.hasNext()){
					CertificadoEvento c = it.next();
					if(c.getIdParticipantes() == participante.getIdParticipante()){
						participanteExiste = true;
						break;
					}
					participanteId++;
				}
				
				if(participanteExiste){
					atividade.setNomeatividade(rs.getString("nomeAtividade"));
					atividade.setCargahoraria(rs.getInt("cargahoraria"));
					linha.get(participanteId).getList().add(atividade);
				}
				else{
					participante.getPessoa().setNomePessoa(rs.getString("nomePessoa"));
					evento.setNomeEvento(rs.getString("nomeEvento"));
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataInicio"));
					evento.setDataInicio(data);
					Calendar data2 = Calendar.getInstance();
					data2.setTime(rs.getDate("dataEncerra"));
					evento.setDataEncerra(data2);
				    atividade.setNomeatividade(rs.getString("nomeAtividade"));
				    atividade.setCargahoraria(rs.getInt("cargahoraria"));

					CertificadoEvento ce = new CertificadoEvento();
					ce.setIdParticipantes(participante.getIdParticipante());
					ce.setNomePessoa(participante.getPessoa().getNomePessoa());
					ce.setNomeEvento(evento.getNomeEvento());
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					ce.setDataInicio(sdf.format(evento.getDataInicio().getTime()));
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
					ce.setDataEncerra(sdf.format(evento.getDataEncerra().getTime()));
					ce.getList().add(atividade);
					linha.add(ce);
					
				}
			}
			rs.close();
			stmt.close();
			//System.out.println(linha.get(0).getList().size());
			return linha;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}


