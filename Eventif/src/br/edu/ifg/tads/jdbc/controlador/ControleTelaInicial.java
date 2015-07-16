package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.edu.ifg.tads.jdbc.controlador.ControleLoginMonitor;
import br.edu.ifg.tads.jdbc.controlador.ControleCadastroParticipante;
import br.edu.ifg.tads.jdbc.controlador.ControleLoginGerente;
import br.edu.ifg.tads.jdbc.dao.GerenteDao;
import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;
import br.edu.ifg.tads.jdbc.modelo.Gerente;
import br.edu.ifg.tads.jdbc.modelo.Monitor;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Presenca;
import br.edu.ifg.tads.jdbc.visao.ViewCadastroParticipante;
import br.edu.ifg.tads.jdbc.visao.ViewLoginGerente;
import br.edu.ifg.tads.jdbc.visao.ViewLoginMonitor;
import br.edu.ifg.tads.jdbc.visao.ViewLoginParticipante;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicial;

public class ControleTelaInicial {

	private ViewTelaInicial tl = null;
	

	public ControleTelaInicial(ViewTelaInicial tl){
	
		this.tl = tl;
		adicionaEventos();
	}

	public void adicionaEventos(){
		//login Gerente
		tl.getBtnNewButtonGerente().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				instanciaUm();
			}
		});

		//login Monitor
		tl.getBtnNewButton_1Monitor().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				instanciaDois();
			}
		});

		//login Participante
		tl.getBtnNewButton_2jaPar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				instanciaTres();
			}
		});

		//cadastrar Participante
		tl.getBtnNewButton_3par().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				instanciaQuatro();
			}
		});
	}
	//Tela de login do Gerente
	public void instanciaUm(){
		//instancia a tela de login para o gerente;
		ViewLoginGerente vlg = new ViewLoginGerente();
		Gerente g = new Gerente();
		GerenteDao gD = new GerenteDao();
		ControleLoginGerente clg = new ControleLoginGerente(vlg, g, gD);
	}
	//Tela de Login do Monitor
	public void instanciaDois(){
		//instancia a tela de login para o gerente;
		Monitor m = new Monitor();
		ViewLoginMonitor vlm = new ViewLoginMonitor();
		ControleLoginMonitor clm = new ControleLoginMonitor(m, vlm);
		
	}
	//Tela de Login do Participante
	public void instanciaTres(){
		ViewLoginParticipante vlp = new ViewLoginParticipante();
		Participante p = new Participante();
		ControleLoginParticipante clp = new ControleLoginParticipante(vlp, p);
	}
	//Tela de Cadastro do Participante
	public void instanciaQuatro(){

		ViewCadastroParticipante vcp = new ViewCadastroParticipante();
		Participante p = new Participante();
		ParticipanteDao pd = new ParticipanteDao();
		ControleCadastroParticipante ccp = new ControleCadastroParticipante(vcp, p, pd);
	}

	
}
