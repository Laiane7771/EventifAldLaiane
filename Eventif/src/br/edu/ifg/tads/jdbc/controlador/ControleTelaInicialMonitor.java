package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Presenca;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicialMonitor;
import br.edu.ifg.tads.jdbc.visao.ViewcheckInCpf;

public class ControleTelaInicialMonitor {
	
	private ViewTelaInicialMonitor vtim;
	private Participante p;
	private Presenca pre;
	private int idLinha;

	public ControleTelaInicialMonitor(ViewTelaInicialMonitor vtim, Participante p){
		this.p = p;
		this.vtim = vtim;
		adicionaEventos();
	}
	
	public void adicionaEventos(){
		vtim.getBtnQRcode().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Esta opção não está disponível!");
				
			}
		});
		vtim.getBtnNewButton_CPF().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					instanciaClasse();
				}catch(Exception e){
					System.out.println(e);
				}
				
			}
		});
		
		vtim.getBtnLogout().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				vtim.getFrame().dispose();
				
			}
		});
	}
	
	public void instanciaClasse(){
		
		ViewcheckInCpf vcic = new ViewcheckInCpf();
		ControleCheckInCheckOut cic = new ControleCheckInCheckOut(vcic, p);
		vtim.getJdp().add(vcic);
		vtim.getJdp().moveToFront(vcic);
	}
	

}
