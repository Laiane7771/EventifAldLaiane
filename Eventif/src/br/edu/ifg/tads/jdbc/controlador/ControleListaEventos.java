package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.jdbc.dao.AtividadeDao;
import br.edu.ifg.tads.jdbc.dao.EventoDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.visao.ViewListaAtividadeMonitor;
import br.edu.ifg.tads.jdbc.visao.ViewListaEvento;

public class ControleListaEventos {
	
	private ViewListaEvento vle;
	private EventoDao eDao = new EventoDao();
	private AtividadeDao aDao = new AtividadeDao();
	private Evento e = new Evento();
	private int idLinha;
	private int idParticipante;
	
	public ControleListaEventos(ViewListaEvento vle, EventoDao eDao, Evento e, int idParticipante){
		this.eDao = eDao;
		this.e = e;
		this.vle = vle;
		adicionaEventos();
		this.idParticipante = idParticipante;
		preencheTabela(eDao.buscaEventos(idLinha));
	}
	
	public void adicionaEventos(){
		
		vle.getBtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Evento e = new Evento();
				e.setNomeEvento(vle.getTextFieldPesquisaEvento().getText());
				Vector<Vector<String>> listaEventos = eDao.buscaEventoNome(e);
				preencheTabela(listaEventos);
			}
		});
		
		vle.getBtnPrximo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Atividade a = new Atividade();
				ViewListaAtividadeMonitor vlam =  new ViewListaAtividadeMonitor();
				ControleListaAtividadeMonitor cla = new ControleListaAtividadeMonitor(vlam, aDao, a, idLinha, idParticipante);
			}
		});
		vle.getBtnVoltar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vle.getFrame().dispose();
				
			}
		});
		
		vle.getTableListaEvento().addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(vle.getTableListaEvento().getValueAt(linha, 0).toString());
				vle.getBtnPrximo().setEnabled(true);
				
			}
		});
		
	}
	
	public void preencheTabela(Vector<Vector<String>> listaEventos){
		vle.getTableListaEvento().clearSelection();
		vle.getTableListaEvento().removeAll();
	
		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Nome");
		colunas.add("Evento");

		DefaultTableModel model = new DefaultTableModel(listaEventos, colunas);
		vle.getTableListaEvento().setModel(model);
		vle.getTableListaEvento().getColumn("id").setMaxWidth(25);
	}

}
