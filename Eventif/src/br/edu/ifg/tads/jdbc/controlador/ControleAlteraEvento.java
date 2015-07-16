
package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import br.edu.ifg.tads.jdbc.dao.EnderecoDao;
import br.edu.ifg.tads.jdbc.dao.EventoDao;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.visao.ViewAlteraEvento;

public class ControleAlteraEvento {

	private ViewAlteraEvento vae;
	private Evento evento;
	private EventoDao edao;
	private EnderecoDao ed = new EnderecoDao();
	private ControleTelaInicialGerenteEvento ctige;

	public ControleAlteraEvento( ViewAlteraEvento vae,Evento evento,EventoDao edao, ControleTelaInicialGerenteEvento ctige){
		this.ctige = ctige;
		this.vae = vae;
		this.evento = evento;
		this.edao = edao;

		adicionaEventos();
		carregaDadosAlteraEvento();
	}
	public void carregaDadosAlteraEvento(){

		vae.getTextFieldNome().setText(evento.getNomeEvento());
		vae.getTextField_Descricao().setText(evento.getDescricao());
		vae.getTextField_Organizador().setText(evento.getOrganizador());
		vae.getTextField_Telefone().setText(evento.getTelefone());
		vae.getTextField_Email().setText(evento.getEmail());


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		vae.getTextFieldDataIni().setText(sdf.format(evento.getDataInicio().getTime()));
		vae.getTextField_DataEncerra().setText(sdf.format(evento.getDataEncerra().getTime()));

		vae.getTextField_LocaldoEv().setText(evento.getEndereco().getLocalDoEvento());
		vae.getTextField_Bairro().setText(evento.getEndereco().getBairro());
		vae.getTextField_Numero().setText(evento.getEndereco().getNumero());
		vae.getTextField_Cidade().setText(evento.getEndereco().getCidade().getNomeCidade());
		vae.getTextFieldEstado().setText(evento.getEndereco().getCidade().getEstado().getNomeEstado());

	}

	public void adicionaEventos(){
		vae.getBtnalterar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Evento et  = new Evento();

				et.setNomeEvento(vae.getTextFieldNome().getText());
				et.setDescricao(vae.getTextField_Descricao().getText());
				et.setOrganizador(vae.getTextField_Organizador().getText());
				et.setTelefone(vae.getTextField_Telefone().getText());
				et.setEmail(vae.getTextField_Email().getText());
				et.setIdEvento(evento.getIdEvento());
				et.getEndereco().setLocalDoEvento(vae.getTextField_LocaldoEv().getText());



				Calendar c = Calendar.getInstance();
				c.setTime(new Date(vae.getTextFieldDataIni().getText()));
				et.setDataInicio(c);

				Calendar d = Calendar.getInstance();
				d.setTime(new Date(vae.getTextField_DataEncerra().getText()));
				et.setDataEncerra(d);

				et.getEndereco().setBairro(vae.getTextField_Bairro().getText());
				et.getEndereco().setNumero(vae.getTextField_Numero().getText());
				et.getEndereco().setIdEndereco(evento.getEndereco().getIdEndereco());
				et.getEndereco().getCidade().setNomeCidade(vae.getTextField_Cidade().getText());
				et.getEndereco().getCidade().setIdCidade(evento.getEndereco().getCidade().getIdCidade());
				et.getEndereco().getCidade().getEstado().setNomeEstado(vae.getTextFieldEstado().getText());
				et.getEndereco().getCidade().getEstado().setIdEstado(evento.getEndereco().getCidade().getEstado().getIdEstado());


				try{
					edao.altera(et);
					edao.alteraEndereco(et.getEndereco());
					ctige.preencheTabela();

				}catch(Exception ex){
					System.out.println(ex);
				}

				//Dispatcher.getInstance().dispatchEvent(new Event("alteracao"));


				vae.dispose();

			}
		});	



		vae.getBtnCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vae.dispose();

			}
		});


	}

}





