package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.jdbc.dao.AtividadeDao;
import br.edu.ifg.tads.jdbc.dao.MonitorDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Monitor;
import br.edu.ifg.tads.jdbc.visao.ViewListaAtividadeMonitor;

public class ControleListaAtividadeMonitor {
	
	private ViewListaAtividadeMonitor vlam;
	private AtividadeDao aDao = new AtividadeDao();
	private MonitorDao mDao = new MonitorDao();
	private Atividade a;
	private Monitor m;
	private int idEvento;
	private int idParticipante;
	private int idAtividade;
	
	public ControleListaAtividadeMonitor(ViewListaAtividadeMonitor vlam, AtividadeDao aDao, Atividade a, int  idEvento, int idParticipante){
		this.vlam = vlam;
		this.aDao = aDao;
		this.a = a;
		this.idEvento = idEvento;
		this.idParticipante = idParticipante;
		adicionaEventos();
		preencheTabela(aDao.buscaAtividades(idEvento));
		
	}
	public void adicionaEventos(){
		
		vlam.getBtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Atividade a = new Atividade();
				a.setNomeAtividade(vlam.getTextField().getText());
				Vector<Vector<String>> listaAtividades = aDao.buscaAtividadeNome(a);
				preencheTabela(listaAtividades);
				
			}
		});
		vlam.getBtnFinalizar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
	
				aDao.insereMonitorAtivi(idParticipante, idAtividade);
				JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
				preencheTabela();
				
			}
		});
		
		vlam.getBtnVoltar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vlam.getFrame().dispose();
			}
		});
		vlam.getTableListaAtividade().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idAtividade = Integer.parseInt(vlam.getTableListaAtividade().getValueAt(linha, 0).toString());
				System.out.println(idEvento);
				vlam.getBtnFinalizar().setEnabled(true);
			
			}
		});
		
	}
	
	public void preencheTabela(){

		preencheTabela(mDao.buscaMonitor());
	}
	
	public void preencheTabela(Vector<Vector<String>> listaAtividades){
		vlam.getTableListaAtividade().clearSelection();
		vlam.getTableListaAtividade().removeAll();
	
		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Evento");
		colunas.add("Atividade");
		colunas.add("Vagas");
		
		DefaultTableModel model = new DefaultTableModel(listaAtividades, colunas);
		vlam.getTableListaAtividade().setModel(model);
		vlam.getTableListaAtividade().getColumn("id").setMaxWidth(25);
	}


}
