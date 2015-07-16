package br.edu.ifg.tads.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import br.edu.ifg.tads.jdbc.bd.ConnectionFactory;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.ContatoPessoa;
import br.edu.ifg.tads.jdbc.modelo.EnderecoPessoa;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.modelo.Monitor;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Pessoa;

public class MonitorDao {

	public int inserir(Participante p){
		int idMonitor = 0;
		Connection con = null;
		try{
			con = new ConnectionFactory().getConnection();


			String sql5 = "insert into Monitor(matricula,idPessoa) values(?,?)";
			PreparedStatement stmt =  con.prepareStatement(sql5, PreparedStatement.RETURN_GENERATED_KEYS);  

			stmt.setString(1, p.getMatricula());
			stmt.setInt(2,p.getPessoa().getIdPessoa());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()){
				idMonitor = rs.getInt("idMonitor");
			}

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
		return idMonitor;
	}

	public Vector<Vector<String>> buscaMonitor(){

		try {
			Vector<Vector<String>> monitores = new Vector<Vector<String>>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement ("SELECT monitor.idMonitor, pessoa.nomePessoa, atividade.nomeAtividade, evento.nomeEvento "+
							"FROM pessoa INNER JOIN monitor ON pessoa.idPessoa = monitor.idPessoa " +
							"INNER JOIN monitorAtividade ON monitor.idMonitor = monitorAtividade.idMonitor " +
							"INNER JOIN atividade ON monitorAtividade.idAtividade = atividade.idAtividade " +
							"INNER JOIN evento ON atividade.idEvento = evento.idEvento ORDER BY monitor.idMonitor");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Monitor
				Evento evento = new Evento();
				Monitor monitor = new Monitor();
				Atividade atividade = new Atividade();

				monitor.setIdMonitor(rs.getInt("idMonitor"));
				monitor.getPessoa().setNomePessoa((rs.getString("nomePessoa")));
				atividade.setNomeAtividade(rs.getString("nomeAtividade"));
				evento.setNomeEvento(rs.getString("nomeEvento"));


				Vector<String> colunas = new Vector<String>();

				colunas.add("" + monitor.getIdMonitor());
				colunas.add(monitor.getPessoa().getNomePessoa());
				colunas.add(atividade.getNomeAtividade());
				colunas.add(evento.getNomeEvento());

				// adicionando o objeto à lista
				monitores.add(colunas);
			}
			rs.close();
			stmt.close();
			return monitores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Monitor buscaPessoaPorCPF(Monitor monitor){
		String sql = "SELECT monitor.idMonitor, pessoa.cpf, pessoa.senha FROM pessoa INNER JOIN monitor ON pessoa.idPessoa = monitor.idPessoa where pessoa.cpf=?";
		Monitor m = null;
		Connection con = null;
			try{
				con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, monitor.getPessoa().getCpf());
				ResultSet rs = stmt.executeQuery();
	
				if(rs.next()){
					m = new Monitor();
					m.setIdMonitor(rs.getInt("idMonitor"));
					m.getPessoa().setCpf(rs.getString("cpf"));
					m.getPessoa().setSenha(rs.getString("senha"));
					//System.out.println(rs.getString("cpf"));
				}
					
		      } catch (Exception e) {
		         throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão"+e.getMessage());
		     }finally{
		    	 try {
					con.close();
				} catch (Exception e) {
					throw new RuntimeException("não foi possível fechar a conexão com o BD");
				}
		     }
			return m;
		 }
	
	public Vector<Vector<String>> buscaMonitoresNome(Monitor monitor){
		try{
			Vector<Vector<String>> monitores = new Vector<Vector<String>>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().
					prepareStatement("Select monitor.idMonitor, pessoa.nomePessoa, atividade.nomeAtividade, evento.nomeEvento from pessoa " +
							"INNER JOIN monitor ON monitor.idPessoa = pessoa.idPessoa " +
							"INNER JOIN monitorAtividade ON monitor.idMonitor = monitorAtividade.idMonitor " +
							"INNER JOIN atividade ON atividade.idAtividade = monitorAtividade.idAtividade " +
							"INNER JOIN evento ON evento.idEvento = atividade.idEvento " +
							"where pessoa.nomePessoa like '%"+monitor.getPessoa().getNomePessoa()+"%'");

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//criando o objeto Monitor
				Monitor m = new Monitor();
				Atividade a = new Atividade();
				Evento e = new Evento();
				m.setIdMonitor(rs.getInt("idMonitor"));
				m.getPessoa().setNomePessoa(rs.getString("nomePessoa"));
				a.setNomeAtividade(rs.getString("nomeAtividade"));
				e.setNomeEvento(rs.getString("nomeEvento"));
		
				Vector<String> colunas = new Vector<String>();
				colunas.add(""+m.getIdMonitor());
				colunas.add(m.getPessoa().getNomePessoa());
				colunas.add(a.getNomeAtividade());
				colunas.add(e.getNomeEvento());
		
				monitores.add(colunas);
			}
			rs.close();
			stmt.close();
			return monitores;
		} catch (SQLException e) {
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
			
			String sql2 = "Update  enderecoPessoa set numero=?,bairro=?,cep=? where idEndereco = ?)";
            
			stmt = con.prepareStatement(sql2);
			stmt.setString(2, enderecoPessoa.getNumero());
			stmt.setString(3,enderecoPessoa.getBairro());
			stmt.setString(1, enderecoPessoa.getCep());
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
	
			
			
			System.out.println(stmt.toString());
	        stmt.close();
	    } catch (SQLException e) {
	   	 System.out.println(e);
	        throw new RuntimeException(e);
	    }
			
	   }
	public void alteraMonitor(Monitor monitor){
		Connection con = null;
		try{
			String sql = "Update monitor set matricula=? where idMonitor=?";
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, monitor.getMatricula());
			
			System.out.println(stmt.toString());
	        stmt.close();
	    } catch (SQLException e) {
	   	 System.out.println(e);
	        throw new RuntimeException(e);
	    }
			
	   }
}