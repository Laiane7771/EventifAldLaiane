package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifg.tads.jdbc.dao.PresencaDao;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Presenca;
import br.edu.ifg.tads.jdbc.visao.ViewTelaEscolhaAtividade;
import br.edu.ifg.tads.jdbc.visao.ViewcheckInCpf;

public class ControleCheckInCheckOut {
	
	private ViewcheckInCpf vcic;
	private PresencaDao psdao = new PresencaDao();
	private Participante p;
	private int idLinha;
	private Presenca pre;
	private int idAtividade;
	private int idParticipante;
	
	
	
	public ControleCheckInCheckOut(ViewcheckInCpf vcic, Participante p){
		this.vcic = vcic;
		this.p = p;
		
		
		adicionaEventos();
	}
	public void adicionaEventos(){
		
		vcic.getBtnEnviar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			if(verificaCPF()){
				instanciaTelaEscolhaAtividade();
			}
				
			}
		});
	}
	
	public boolean verificaCPF(){
		Participante p1 = new Participante();
		p1.getPessoa().setCpf(vcic.getTextField().getText());
	
		try{
			p = psdao.buscaPessoaPorCPF(p1);
			if(p!=null){
				if(p1.getPessoa().getCpf().equals(p.getPessoa().getCpf()));
				return true;
			}
			else{
				JOptionPane.showMessageDialog(null, "CPF não encontrado!");
				//usuario nao existe
				return false;
			}
		}catch(Exception ex){
			System.out.println(ex);
			return false;
		}
		
	}
	
	public void instanciaTelaEscolhaAtividade(){
		ViewTelaEscolhaAtividade vtea = new ViewTelaEscolhaAtividade();
		ControleTelaEscolhaAtividade ctea = new ControleTelaEscolhaAtividade(vtea, p,idLinha,pre);
	}
}
