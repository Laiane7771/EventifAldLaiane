package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import br.edu.ifg.tads.jdbc.dao.AtividadeDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.visao.ViewCadastroNovaAtividade;

public class ControleCadastroNovaAtividade {

	private ViewCadastroNovaAtividade vcna;
	private AtividadeDao adao = new AtividadeDao();
	private Atividade a;
	private ControleListaAtividades cla;
	private int idLinha;

	public ControleCadastroNovaAtividade(ViewCadastroNovaAtividade vcna,Atividade a, int idLinha ){
		this.vcna = vcna;
		this.a = a;
		this.idLinha = idLinha;
		adicionaEventos();
	}

	public void adicionaEventos(){

		vcna.getBtnSalvar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				adicionarAtividade();
				vcna.dispose();
				cla.preencheTabela();
				
				
			}
		});

	}

	public void adicionarAtividade(){

		a.setNomeAtividade(vcna.getTextFieldNome().getText());
		a.setDescricaoAt(vcna.getTextField_Descricao().getText());
		a.getTipoativi().setTipoAtividade(vcna.getTextField_TipoAtivi().getText());
		a.setMinistrante(vcna.getTextField_Ministrante().getText());
		int b = Integer.parseInt(vcna.getTextField_NumeroVagas().getText());
		a.setNumeroVagas(b);
	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			a.setHoraInicio(new Time(sdf.parse(vcna.getTextFieldHoraInicio().getText()).getTime()));
			a.setHoraEncerra(new Time(sdf.parse(vcna.getTextField_HoraEncerra().getText()).getTime()));
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf1.parse(vcna.getTextField_Data().getText()));
			a.setData(c);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		if(vcna.getTextFieldNome().getText().isEmpty()|| vcna.getTextField_Descricao().getText().isEmpty()
				||vcna.getTextField_TipoAtivi().getText().isEmpty()||vcna.getTextField_Ministrante().getText().isEmpty()
				||vcna.getTextField_NumeroVagas().getText().isEmpty()||vcna.getTextFieldHoraInicio().getText().isEmpty()
				||vcna.getTextField_HoraEncerra().getText().isEmpty()||vcna.getTextField_Data().getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Por favor, preencha os espaços vazios!");

		}
		else{
			try{
				AtividadeDao adao = new AtividadeDao();
				adao.insere(a);
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");

			}catch(Exception ex){
				System.out.println(ex.getMessage());

			} 
		}
	}




}
