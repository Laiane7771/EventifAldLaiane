
package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.edu.ifg.tads.jdbc.dao.AtividadeDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.visao.ViewAlteraAtividade;

public class ControleAlteraAtividade {
	private ViewAlteraAtividade vaa;
	private AtividadeDao adao;
	private Atividade atividade;
	
	public ControleAlteraAtividade(ViewAlteraAtividade vaa,Atividade atividade,AtividadeDao adao){
		this.vaa = vaa;
		this.atividade = atividade;
		this.adao = adao;
		
		adicionaEventos();
		carregaDadosAtividadeAltera();
	}
	
	public void carregaDadosAtividadeAltera(){
	
		vaa.getTextFieldNome().setText(atividade.getNomeAtividade());
		vaa.getTextField_Descricao().setText(atividade.getDescricaoAt());
	
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		vaa.getTextField_Data().setText(sdf1.format(atividade.getData().getTime()));
	
		
		vaa.getTextField_TipoAtivi().setText(atividade.getTipoativi().getTipoAtividade());
		vaa.getTextField_Ministrante().setText(atividade.getMinistrante());
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		vaa.getTextFieldHoraInicio().setText(sdf.format(atividade.getHoraInicio().getTime()));
		vaa.getTextField_HoraEncerra().setText(sdf.format(atividade.getHoraEncerra().getTime()));
		
		vaa.getTextField_NumeroVagas().setText(atividade.getNumeroVagas()+"");
		
	}
	
	public void adicionaEventos(){
		vaa.getBtnAlterar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Atividade at = new Atividade();
				
				at.setNomeAtividade(vaa.getTextFieldNome().getText());
				at.setDescricaoAt(vaa.getTextField_Descricao().getText());
				
				Calendar c = Calendar.getInstance();
				c.setTime(new Date(vaa.getTextField_Data().getText()));
				at.setData(c);
				
				at.getTipoativi().setTipoAtividade(vaa.getTextField_TipoAtivi().getText());
				at.getTipoativi().setIdtipoativi(at.getTipoativi().getIdtipoativi());
				at.setMinistrante(vaa.getTextField_Ministrante().getText());
				
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				try {
					at.setHoraInicio(new Time(sdf.parse(vaa.getTextFieldHoraInicio().getText()).getTime()));
					at.setHoraEncerra(new Time(sdf.parse(vaa.getTextField_HoraEncerra().getText()).getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				int b = Integer.parseInt(vaa.getTextField_NumeroVagas().getText());
				at.setNumeroVagas(b);
				
				try{
					adao.alteraAtividade(at);
					adao.alteraTipoAtividade(at.getTipoativi());
				}catch(Exception ex){
					System.out.println(ex);
				}
				
				//Dispatcher.getInstance().dispatchEvent(new Event("alteracao"));

				
				vaa.dispose();
				
			}
		});	
		

           vaa.getBtnCancelar().addActionListener(new ActionListener() {
   			
   			@Override
   			public void actionPerformed(ActionEvent e) {
   				vaa.dispose();
   				
   			}
   		});
   	
   	
   }
   	
  }
     
  