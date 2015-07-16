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
import br.edu.ifg.tads.jdbc.dao.MonitorDao;
import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.modelo.Monitor;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.visao.ViewEscolhaAtividadepMonitor;
import br.edu.ifg.tads.jdbc.visao.ViewListaEvento;
import br.edu.ifg.tads.jdbc.visao.ViewListaTodosAlunos;


public class ControleListaTodosAlunos {

	private ViewListaTodosAlunos vlta;
	private Atividade a;
	private MonitorDao mDao;
	private EventoDao eDao = new EventoDao();
	private AtividadeDao aDao = new AtividadeDao();
	private ParticipanteDao pDao = new ParticipanteDao();
	private Participante p;
	private ViewEscolhaAtividadepMonitor veam;
	private int idLinha;


	public ControleListaTodosAlunos( ViewListaTodosAlunos vlta, Participante p, ParticipanteDao pDao){
		this.vlta = vlta;
		this.p = p;
		this.pDao = pDao;
		adicionaEventos();
		preencheTabela(pDao.buscaParticipantes());

	}

	public void adicionaEventos(){
		
		vlta.getBtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Participante p = new Participante();
				p.getPessoa().setNomePessoa(vlta.getTextFieldPesquisar().getText());
				Vector<Vector<String>> listaParticipantes = pDao.buscaParticipanteNome(p);
				preencheTabela(listaParticipantes);
			}
		});
		vlta.getBtnProximo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				instanciaListaEvento();
			}
		});
		vlta.getBtnVoltar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vlta.getFrame().dispose();
				
			}
		});
		
		vlta.getTableListaAluno().addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(vlta.getTableListaAluno().getValueAt(linha, 0).toString());
				vlta.getBtnProximo().setEnabled(true);
				
			}
		});
		
	}
	public void preencheTabela(Vector<Vector<String>> listaParticipantes){
		vlta.getTableListaAluno().clearSelection();
		vlta.getTableListaAluno().removeAll();
	
		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Nome");
		colunas.add("Evento");

		DefaultTableModel model = new DefaultTableModel(listaParticipantes, colunas);
		vlta.getTableListaAluno().setModel(model);
		vlta.getTableListaAluno().getColumn("id").setMaxWidth(25);
	}
	
	public void instanciaListaEvento(){
		EventoDao eDao = new EventoDao();
		Evento e = new Evento();
		ViewListaEvento vle = new ViewListaEvento();
		ControleListaEventos cle = new ControleListaEventos(vle, eDao, e, idLinha);
	}




}

