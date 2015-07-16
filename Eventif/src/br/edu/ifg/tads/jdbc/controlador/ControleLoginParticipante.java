package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.visao.ViewLoginParticipante;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicialParticipante;

public class ControleLoginParticipante {

	private ViewLoginParticipante vlP = null;
	private Participante p = new Participante();
	private ParticipanteDao pd = new ParticipanteDao();
	private int idLinha;

	public ControleLoginParticipante(ViewLoginParticipante vlP, Participante p){
		this.vlP = vlP;
		this.p = p;
		adicionaEventos();
	}


	public void adicionaEventos(){


		vlP.getBtnLogin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(verificaLogin()){
					instanciaClasse();
				}
				else{
					JOptionPane.showMessageDialog(null,"Usuario ou senha errados!");
				}
			}
		});

		vlP.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				vlP.getFrame().dispose();

			}
		});


	}
	public boolean verificaLogin(){
		Participante pl = new Participante();
		pl.getPessoa().setCpf(vlP.getTextFieldParticipante().getText());
		pl.getPessoa().setSenha(vlP.getPasswordFieldParticipante().getText());

		try{
			p = pd.buscaPessoaPorCPF(pl);
			if(p!=null){
				if(pl.getPessoa().getSenha().equals(p.getPessoa().getSenha())){
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

		ViewTelaInicialParticipante vtip = new ViewTelaInicialParticipante();
		ControleTelaInicialParticipante cipe = new ControleTelaInicialParticipante(vtip, p, idLinha);
		vlP.getFrame().dispose();
	}
}