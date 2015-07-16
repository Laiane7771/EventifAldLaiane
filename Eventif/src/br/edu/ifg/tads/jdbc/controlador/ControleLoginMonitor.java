package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.edu.ifg.tads.jdbc.dao.MonitorDao;
import br.edu.ifg.tads.jdbc.modelo.Monitor;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Presenca;
import br.edu.ifg.tads.jdbc.visao.ViewLoginMonitor;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicialMonitor;


public class ControleLoginMonitor {

	private MonitorDao mdao = new MonitorDao();
	private ViewLoginMonitor vlm;
	private Monitor m;
	private Participante p;

	public ControleLoginMonitor(Monitor m, ViewLoginMonitor vlm){
		this.vlm = vlm;
		this.m = m;
		adicionaEventos();
	}


	public void adicionaEventos(){

		vlm.getBtnLogin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(verificaLogin()){
					instanciaClasse();
				}
				
				vlm.getFrame().dispose();
			}
		});

		vlm.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				vlm.getFrame().dispose();
			}
		});
	}

	public boolean verificaLogin(){
		Monitor m = new Monitor();
		m.getPessoa().setCpf(vlm.getTextField().getText());
		m.getPessoa().setSenha(vlm.getPasswordField().getText());
		try{
			Monitor monitorBD = mdao.buscaPessoaPorCPF(m);
			if(monitorBD!=null){
				if(m.getPessoa().getSenha().equals(monitorBD.getPessoa().getSenha())){
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

		ViewTelaInicialMonitor vtim = new ViewTelaInicialMonitor();
		ControleTelaInicialMonitor ctim = new ControleTelaInicialMonitor(vtim, p);
		//vlm.getFrame().dispose();
	}
}


