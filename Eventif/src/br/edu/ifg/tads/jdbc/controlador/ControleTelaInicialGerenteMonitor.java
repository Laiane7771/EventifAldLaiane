package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.edu.ifg.tads.jdbc.modelo.Monitor;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.visao.ViewListaEvento;
import br.edu.ifg.tads.jdbc.visao.ViewListaTodosAlunos;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicialGerente;
import br.edu.ifg.tads.jdbc.dao.MonitorDao;
import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;

public class ControleTelaInicialGerenteMonitor {

	private ViewTelaInicialGerente vtig;
	private Monitor m;
	private Participante p;
	private MonitorDao mdao = new MonitorDao();
	private ParticipanteDao pDao = new ParticipanteDao();
	private int idLinha;

	public ControleTelaInicialGerenteMonitor( ViewTelaInicialGerente vtig, Monitor m, MonitorDao mdao){
		this.vtig = vtig;
		this.m = m;
		this.mdao = mdao;
		adicionaEventos();
		preencheTabela(mdao.buscaMonitor());
	}

	public void adicionaEventos(){


		vtig.getBtnPesquisar_Monitor().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Monitor m = new Monitor();
				m.getPessoa().setNomePessoa(vtig.getTexpesquisar_monitor().getText());
				Vector<Vector<String>> listaMonitores = mdao.buscaMonitoresNome(m);
				preencheTabela(listaMonitores);

			}
		} );

		

		vtig.getBtnNovoMonitor().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ViewListaTodosAlunos vlta = new ViewListaTodosAlunos();
				MonitorDao mdao = new MonitorDao();
				ControleListaTodosAlunos clta = new ControleListaTodosAlunos(vlta,p, pDao);
				
			}
		});

		vtig.getTable_Monitor().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(vtig.getTable_Monitor().getValueAt(linha, 0).toString());
				
			}
		});

	}
	public void preencheTabela(){

		preencheTabela(mdao.buscaMonitor());
	}
	public void preencheTabela(Vector<Vector<String>> listaMonitores){
		vtig.getTable_Monitor().clearSelection();
		vtig.getTable_Monitor().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Nome");
		colunas.add("Atividade");
		colunas.add("Evento");

		DefaultTableModel model = new DefaultTableModel(listaMonitores, colunas);
		vtig.getTable_Monitor().setModel(model);
		vtig.getTable_Monitor().getColumn("id").setMaxWidth(25);
	}

	


}
