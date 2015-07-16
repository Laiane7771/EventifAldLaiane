package br.edu.ifg.tads.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import br.edu.ifg.tads.jdbc.bd.ConnectionFactory;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.ContatoPessoa;
import br.edu.ifg.tads.jdbc.modelo.EnderecoPessoa;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Pessoa;

public class ParticipanteDao {


	public void inserir(Participante participante){

		Connection con = null;

		try{
			String sql = "insert into estado"+
					"(nomeestado) values (?)";
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1,participante.getPessoa().getEnderecopessoa().getCidade().getEstado().getNomeEstado());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			int idEstado = 0;
			if(rs.next()){
				idEstado = rs.getInt("idestado");
			}
			System.out.println(idEstado);


			String sql1 = "insert into Cidade(nomeCidade,idEstado) values(?,?)";
			stmt = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, participante.getPessoa().getEnderecopessoa().getCidade().getNomeCidade());
			stmt.setInt(2,idEstado);
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			int idCidade = 0;
			if(rs.next()){
				idCidade = rs.getInt("idcidade");
			}
			System.out.println(idCidade);

			String sql2 = "insert into EnderecoPessoa"
					+"(numero,bairro,cep,idCidade) values (?,?,?,?)";
			stmt = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, participante.getPessoa().getEnderecopessoa().getNumero());
			stmt.setString(2, participante.getPessoa().getEnderecopessoa().getBairro());
			stmt.setString(3, participante.getPessoa().getEnderecopessoa().getCep());
			stmt.setInt(4, idCidade);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			int idEnderecoPessoa = 0;
			if(rs.next()){
				idEnderecoPessoa = rs.getInt("idenderecopessoa");
			}
			System.out.println(idEnderecoPessoa);



			String sql3 = "insert into ContatoPessoa"
					+"(email,telefonePessoa) values (?,?)";

			stmt = con.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, participante.getPessoa().getContatopessoa().getEmail());
			stmt.setString(2, participante.getPessoa().getContatopessoa().getTelefonePessoa());

			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			int idContatoPessoa = 0;
			if(rs.next()){
				idContatoPessoa = rs.getInt("idContatoPessoa");
			}
			System.out.println(idContatoPessoa);


			String sql4 = "insert into Pessoa(nomePessoa,cpf,rg,senha,idEnderecoPessoa,idContatoPessoa) values(?,?,?,?,?,?)";

			stmt = con.prepareStatement(sql4, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, participante.getPessoa().getNomePessoa());
			stmt.setString(2, participante.getPessoa().getCpf());
			stmt.setString(3, participante.getPessoa().getRg());
			stmt.setString(4, participante.getPessoa().getSenha());
			stmt.setInt(5, idEnderecoPessoa);
			stmt.setInt(6, idContatoPessoa);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			int idPessoa = 0;
			if(rs.next()){
				idPessoa = rs.getInt("idPessoa");
			}
			System.out.println(idPessoa);


			String sql5 = "insert into participante(matricula,idPessoa) values(?,?)";
			stmt =  con.prepareStatement(sql5);  

			stmt.setString(1, participante.getMatricula());
			stmt.setInt(2,idPessoa);

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
	public Vector<Vector<String>> buscaParticipantes(){

		try {
			Vector<Vector<String>> participantes = new Vector<Vector<String>>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement("SELECT distinct participante.idParticipante, pessoa.nomePessoa, evento.nomeEvento FROM pessoa "+
							"INNER JOIN participante ON pessoa.idPessoa = participante.idPessoa "+
							"INNER JOIN participaativi ON participante.idParticipante = participaativi.idParticipante "+
							"INNER JOIN atividade ON participaativi.idAtividade = atividade.idAtividade "+
							"INNER JOIN evento ON atividade.idevento = evento.idEvento ORDER BY participante.idParticipante");
			
			
							ResultSet rs = stmt.executeQuery();

							while (rs.next()) {
								// criando o objeto Contato
								Evento evento = new Evento();
								Participante participante = new Participante();
								participante.setIdParticipante(rs.getInt("idParticipante"));
								participante.getPessoa().setNomePessoa(rs.getString("nomePessoa"));
								evento.setNomeEvento(rs.getString("nomeEvento"));

								Vector<String> colunas = new Vector<String>();
								colunas.add(""+participante.getIdParticipante());
								colunas.add(participante.getPessoa().getNomePessoa());
								colunas.add(evento.getNomeEvento());
								
								participantes.add(colunas);
							}
							rs.close();
							stmt.close();
							return participantes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Participante buscaPessoaPorCPF(Participante participante){
		String sql = "SELECT participante.idParticipante,pessoa.cpf, pessoa.senha FROM pessoa INNER JOIN participante ON pessoa.idPessoa = participante.idPessoa where pessoa.cpf=?";
		Participante p = null;
		Connection con = null;
			try{
				con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, participante.getPessoa().getCpf());
				ResultSet rs = stmt.executeQuery();
	
				if(rs.next()){
					p = new Participante();
					p.setIdParticipante(rs.getInt("idParticipante"));
					p.getPessoa().setCpf(rs.getString("cpf"));
					p.getPessoa().setSenha(rs.getString("senha"));
					//System.out.println(rs.getString("cpf"));
				}
					
		      } catch (Exception e) {
		         throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão " + e.getMessage());
		     }finally{
		    	 try {
					con.close();
				} catch (Exception e) {
					throw new RuntimeException("não foi possível fechar a conexão com o BD");
				}
		     }
			return p;
		 }
	
	public Participante buscaParticipanteporID(Participante participante){
		
		String sql = "SELECT participante.idParticipante, pessoa.idPessoa, participante.matricula  FROM  participante" +
				" INNER JOIN pessoa ON pessoa.idPessoa = participante.idPessoa" 
						+ " where participante.idparticipante = "+ participante.getIdParticipante();

		Participante p = null;
		Connection con = null;
			try{
				con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
	
				if(rs.next()){
					p = new Participante();
					p.setIdParticipante(rs.getInt("idParticipante"));
					p.getPessoa().setIdPessoa(rs.getInt("idPessoa"));
					p.setMatricula(rs.getString("matricula"));
				}
					
		      } catch (Exception e) {
		         throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão " + e.getMessage());
		     }finally{
		    	 try {
					con.close();
				} catch (Exception e) {
					throw new RuntimeException("não foi possível fechar a conexão com o BD");
				}
		     }
			return p;
		 }
		 

	public Vector<Vector<String>> buscaParticipanteNome(Participante participante){
		try{
			Vector<Vector<String>> participantes = new Vector<Vector<String>>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement("Select DISTINCT participante.idParticipante, pessoa.nomePessoa, evento.nomeEvento from pessoa " +
							"INNER JOIN participante ON participante.idPessoa = pessoa.idPessoa " +
							"INNER JOIN participaAtivi ON participante.idParticipante = participaAtivi.idParticipante " +
							"INNER JOIN atividade ON atividade.idAtividade = participaAtivi.idAtividade " +
							"INNER JOIN evento ON evento.idEvento = atividade.idEvento " +
							"where pessoa.nomePessoa like '%"+participante.getPessoa().getNomePessoa()+"%'");

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//criando o objeto Participante
				Participante p = new Participante();
				Evento e = new Evento();
				p.setIdParticipante(rs.getInt("idParticipante"));
				p.getPessoa().setNomePessoa(rs.getString("nomePessoa"));
				e.setNomeEvento(rs.getString("nomeEvento"));
		
				Vector<String> colunas = new Vector<String>();
				colunas.add(""+p.getIdParticipante());
				colunas.add(p.getPessoa().getNomePessoa());
				colunas.add(e.getNomeEvento());
		
				participantes.add(colunas);
			}
			rs.close();
			stmt.close();
			return participantes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Vector<Vector<String>> ExibeAtividadeParticipante(int idParticipante){
		try{
			Participante p = new Participante();
			Vector<Vector<String>> atividades = new Vector<Vector<String>>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement("SELECT DISTINCT atividade.idAtividade, atividade.nomeAtividade, atividade.horaInicio, atividade.horaEncerra from pessoa "+
							"INNER JOIN participante ON participante.idPessoa = pessoa.idPessoa "+
							"INNER JOIN participaAtivi ON participante.idParticipante = participaAtivi.idParticipante "+
							"INNER JOIN atividade ON atividade.idAtividade = participaAtivi.idAtividade "+
							"WHERE participante.idParticipante ="+ idParticipante);
			
			System.out.println(p.getIdParticipante());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//criando o objeto Atividade
				Atividade a = new Atividade();
				a.setIdAtividade(rs.getInt("idAtividade"));
				a.setNomeAtividade(rs.getString("nomeAtividade"));
				a.setHoraInicio(rs.getTime("horaInicio"));
				a.setHoraEncerra(rs.getTime("horaEncerra"));
				
				Vector<String> colunas = new Vector<String>();
				colunas.add(""+a.getIdAtividade());
				colunas.add(a.getNomeAtividade());
				colunas.add("" + a.getHoraInicio());
				colunas.add("" + a.getHoraEncerra());
		
				atividades.add(colunas);
			}
			rs.close();
			stmt.close();
			
		return atividades;
		
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	public void alteraEnderecoPessoa(EnderecoPessoa enderecoPessoa){
		Connection con = null;
		
		try{
			String sql = "Update estado set nomeestado = ? where idEstado = ?";

			
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, enderecoPessoa.getCidade().getEstado().getNomeEstado());
			stmt.setInt(2, enderecoPessoa.getCidade().getEstado().getIdEstado());
			
			stmt.executeUpdate();
			
			
			String sql1 = "Update Cidade set nomeCidade=? where idCidade = ?";
			stmt = con.prepareStatement(sql1);
			stmt.setString(1, enderecoPessoa.getCidade().getNomeCidade());
			stmt.setInt(2,enderecoPessoa.getCidade().getIdCidade());
			stmt.executeUpdate();
			
			String sql2 = "Update  enderecoPessoa set numero=?,bairro=?,cep=? where idEnderecoPessoa = ?";
            
			stmt = con.prepareStatement(sql2);
			stmt.setString(2, enderecoPessoa.getNumero());
			stmt.setString(3,enderecoPessoa.getBairro());
			stmt.setString(1, enderecoPessoa.getCep());
			stmt.setInt(4, enderecoPessoa.getIdEnderecoPessoa());
			stmt.executeUpdate();
	
			System.out.println(stmt.toString());
	        stmt.close();
	    } catch (SQLException e) {
	   	 System.out.println(e);
	        throw new RuntimeException(e);
	    }
			
	   }
	public void alteraContatoPessoa(ContatoPessoa contatoPessoa){
		Connection con = null;
		try{
			String sql = "Update contatoPessoa set email=?,telefonePessoa=? where idContatoPessoa =?";
			
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,contatoPessoa.getEmail());
			stmt.setString(2, contatoPessoa.getTelefonePessoa());
			stmt.setInt(3, contatoPessoa.getIdContatoPessoa());
			
			stmt.executeUpdate();
			
			System.out.println(stmt.toString());
	        stmt.close();
	    } catch (SQLException e) {
	   	 System.out.println(e);
	        throw new RuntimeException(e);
	    }
			
	   }
	public void alteraPessoa(Pessoa pessoa){
		Connection con = null;
		try{
			String sql = "Update pessoa set nomePessoa=?,cpf=?,rg=?,senha=? where idPessoa =?";
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, pessoa.getNomePessoa());
			stmt.setString(2,pessoa.getCpf());
			stmt.setString(3, pessoa.getRg());
			stmt.setString(4, pessoa.getSenha());
			stmt.setInt(5, pessoa.getIdPessoa());
	
			
			
			System.out.println(stmt.toString());
	        stmt.close();
	    } catch (SQLException e) {
	   	 System.out.println(e);
	        throw new RuntimeException(e);
	    }
			
	   }
	public void alteraParticipante(Participante participante){
		Connection con = null;
		try{
			String sql = "Update participante set matricula=? where idParticipante=?";
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, participante.getMatricula());
			stmt.setInt(2, participante.getIdParticipante());
			
			System.out.println(stmt.toString());
	        stmt.close();
	    } catch (SQLException e) {
	   	 System.out.println(e);
	        throw new RuntimeException(e);
	    }
	}
			
	   
	public Participante buscaparticipante(Participante p){
		System.out.println(p.getIdParticipante());
	    Participante participante = new Participante();
		try{
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement("Select * from participante inner join pessoa on participante.idPessoa = pessoa.idPessoa "
							+ "inner join contatoPessoa on pessoa.idContatoPessoa = contatoPessoa.idContatoPessoa "
							+ "inner join enderecoPessoa on pessoa.idEnderecoPessoa = enderecoPessoa.idEnderecoPessoa "
							+ "inner join cidade on enderecoPessoa.idCidade = cidade.idCidade "
							+ "inner join estado on cidade.idEstado = estado.idEstado where idparticipante = "+ p.getIdParticipante());
	         ResultSet rs = stmt.executeQuery();		
					
			if(rs.next()){
				participante.setIdParticipante(rs.getInt("idparticipante"));
				participante.setMatricula(rs.getString("matricula"));
				participante.getPessoa().setNomePessoa(rs.getString("nomePessoa"));
				participante.getPessoa().setCpf(rs.getString("cpf"));
				participante.getPessoa().setRg(rs.getString("rg"));
				participante.getPessoa().setSenha(rs.getString("senha"));
				participante.getPessoa().getContatopessoa().setEmail(rs.getString("email"));
				participante.getPessoa().getContatopessoa().setTelefonePessoa(rs.getString("telefonePessoa"));
				participante.getPessoa().getEnderecopessoa().setBairro(rs.getString("bairro"));
				participante.getPessoa().getEnderecopessoa().setCep(rs.getString("cep"));
				participante.getPessoa().getEnderecopessoa().setNumero(rs.getString("numero"));
				participante.getPessoa().getEnderecopessoa().getCidade().setNomeCidade(rs.getString("nomeCidade"));
				participante.getPessoa().getEnderecopessoa().getCidade().getEstado().setNomeEstado(rs.getString("nomeEstado"));
				
			 }
	         rs.close();
	         stmt.close();
	     } catch (SQLException ex) {
	         throw new RuntimeException(ex);
	     }
		return participante;
	}
}



