package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import br.edu.ifg.tads.jdbc.dao.EventoDao;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.visao.ViewCadastrarNovoEvento;


public class ControleCadastrarNovoEvento {

	private ViewCadastrarNovoEvento vcne;
	private Evento e;
	private ControleTelaInicialGerenteEvento ctige;

	public ControleCadastrarNovoEvento(ViewCadastrarNovoEvento vcne, Evento e,ControleTelaInicialGerenteEvento ctige ){
		this.vcne = vcne;
		this.ctige = ctige;
		this.e = e;
		adicionaEvento();

	}

	public void adicionaEvento(){

		vcne.getBtnSalvar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				inscreverEvento();
				ctige.preencheTabela();

			}
		});
	}

	public void inscreverEvento(){

		Evento e = new Evento();
		e.setNomeEvento(vcne.getTextFieldNome().getText()); 
		e.setDescricao(vcne.getTextField_Descricao().getText());
		e.setOrganizador(vcne.getTextField_Organizador().getText());
		e.setTelefone(vcne.getTextField_Telefone().getText());
		e.setEmail(vcne.getTextField_Email().getText());
		e.getEndereco().setLocalDoEvento(vcne.getTextField_LocaldoEv().getText());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(vcne.getTextFieldDataIni().getText()));
			e.setDataInicio(c);
			Calendar d = Calendar.getInstance();
			d.setTime(sdf.parse(vcne.getTextField_DataEncerra().getText()));
			e.setDataEncerra(d);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		e.getEndereco().setBairro(vcne.getTextField_Bairro().getText());
		e.getEndereco().setNumero(vcne.getTextField_Numero().getText());
		e.getEndereco().getCidade().setNomeCidade(vcne.getTextField_Cidade().getText());
		e.getEndereco().getCidade().getEstado().setNomeEstado(vcne.getTextFieldEstado().getText());
		e.getEndereco().setCep(vcne.getTextField_cep().getText());

		if(vcne.getTextFieldNome().getText().isEmpty()||vcne.getTextField_Descricao().getText().isEmpty()||vcne.getTextField_Organizador().getText().isEmpty()
				||vcne.getTextField_Telefone().getText().isEmpty()||vcne.getTextField_Email().getText().isEmpty()||vcne.getTextField_LocaldoEv().getText().isEmpty()
				||vcne.getTextField_Bairro().getText().isEmpty()||vcne.getTextField_Numero().getText().isEmpty()||vcne.getTextField_Cidade().getText().isEmpty()
				||vcne.getTextFieldDataIni().getText().isEmpty()||vcne.getTextField_DataEncerra().getText().isEmpty()||vcne.getTextFieldEstado().getText().isEmpty()||vcne.getTextField_cep().getText().isEmpty()){

			JOptionPane.showMessageDialog(null, "Por favor, Preencha os campos vazios!");
		}
		else{
			EventoDao ed = new EventoDao();
			ed.insira(e);
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
			vcne.dispose();

		}
	}

}
