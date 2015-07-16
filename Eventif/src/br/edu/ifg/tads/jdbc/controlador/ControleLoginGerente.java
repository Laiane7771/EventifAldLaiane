package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.edu.ifg.tads.jdbc.dao.GerenteDao;
import br.edu.ifg.tads.jdbc.dao.MonitorDao;
import br.edu.ifg.tads.jdbc.modelo.Gerente;
import br.edu.ifg.tads.jdbc.modelo.Monitor;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.visao.ViewCadastrarNovoEvento;
import br.edu.ifg.tads.jdbc.visao.ViewLoginGerente;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicialGerente;


public class ControleLoginGerente {
	
	private ViewLoginGerente vlg;
	private Gerente gE;
	private GerenteDao gd;
	
	
	public ControleLoginGerente(final ViewLoginGerente vlg, Gerente gE, GerenteDao gd){
		this.vlg = vlg;
		this.gE = gE;
		this.gd = gd;
		adicionaEvento();
	}
	
	public void adicionaEvento(){
	
		//login Gerente
		vlg.getBtnLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				if(verificaLogin()){
					instanciaClasse();
				}
				else{
				JOptionPane.showMessageDialog(null,"Usuario ou senha errados!");
				}
				
				
			}
		});
		
		vlg.getBtnVoltar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				vlg.getFrame().dispose();
				
			} 
		});
	}
	
	public boolean verificaLogin(){
		Gerente g = new Gerente();
		g.getPessoa().setCpf(vlg.getTextFieldgerente().getText());
		g.getPessoa().setSenha(vlg.getPasswordFieldGerente().getText());
		try{
			Gerente gerenteBD = gd.buscaPessoaPorCPF(g);
			if(gerenteBD!=null){
				if(g.getPessoa().getSenha().equals(gerenteBD.getPessoa().getSenha())){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Usuário não existe");
				//usuario nao existe
				return false;
			}
		}catch(Exception ex){
			System.out.println(ex);
			return false;
		} 
	}
	public void instanciaClasse(){
		
		Gerente g = new Gerente();
		Monitor m = new Monitor();
		vlg.getFrame().dispose();
		ViewTelaInicialGerente vtig = new ViewTelaInicialGerente();
		ViewCadastrarNovoEvento vcne = new ViewCadastrarNovoEvento();
		GerenteDao gd = new GerenteDao();
		MonitorDao mdao = new MonitorDao();
		ControleTelaInicialGerenteEvento ctig = new ControleTelaInicialGerenteEvento(vtig, g, gd, vcne);
		ControleTelaInicialGerenteMonitor ctigm = new ControleTelaInicialGerenteMonitor(vtig,m, mdao);
		ControleTelaInicialGerenteParticipante ctigp = new ControleTelaInicialGerenteParticipante(vtig, new Participante());
		
	}
}
