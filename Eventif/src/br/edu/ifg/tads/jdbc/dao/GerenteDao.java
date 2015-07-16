package br.edu.ifg.tads.jdbc.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.edu.ifg.tads.jdbc.bd.ConnectionFactory;
import br.edu.ifg.tads.jdbc.modelo.Gerente;
import br.edu.ifg.tads.jdbc.modelo.Pessoa;

public class GerenteDao {

	public String busca(Gerente gerente){
		String sql = "SELECT pessoa.cpf, pessoa.senha FROM pessoa INNER JOIN gerente ON pessoa.idPessoa = gerente.idPessoa";

		Connection con = null;
		try{
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			Pessoa p = new Pessoa();


			while(rs.next()){
				p.setCpf(rs.getString("cpf"));
				p.setSenha(rs.getString("senha"));
				//System.out.println(rs.getString("cpf"));

			}


		} catch (Exception e) {
			throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão");
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("não foi possível fechar a conexão com o BD");
			}
		}
		return null;
	}

	public Gerente buscaPessoaPorCPF(Gerente gerente){
		String sql = "SELECT pessoa.cpf, pessoa.senha FROM pessoa INNER JOIN gerente ON pessoa.idPessoa = gerente.idPessoa where pessoa.cpf=?";
		Gerente p = null;
		Connection con = null;
		try{
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, gerente.getPessoa().getCpf());
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				p = new Gerente();
				p.getPessoa().setCpf(rs.getString("cpf"));
				p.getPessoa().setSenha(rs.getString("senha"));
				//System.out.println(rs.getString("cpf"));
			}

		} catch (Exception e) {
			throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão");
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("não foi possível fechar a conexão com o BD");
			}
		}
		return p;
	}




}







