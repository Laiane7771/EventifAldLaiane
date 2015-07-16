package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.jdbc.dao.AtividadeDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.visao.ViewInscreverEmAtividade;

public class ControleInscreverEmAtividade {
	private Atividade a = new Atividade();
	private ViewInscreverEmAtividade viea;
	private AtividadeDao aidao = new AtividadeDao();
	private int idLinha;
	private Participante p;

	public ControleInscreverEmAtividade(ViewInscreverEmAtividade viea, Participante p, int idLinha){
		this.p = p;
		this.idLinha = idLinha;
		this.viea = viea;
		preencheTabela(aidao.buscaAtividades(idLinha));
		adicionaEventos();

	}

	public void adicionaEventos(){

		viea.getBtnPequisar_atividade().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Atividade a = new Atividade();
				a.setNomeAtividade(viea.getTextField_Inscrever().getText());
				Vector<Vector<String>> listaAtividades = aidao.buscaAtividadeNome(a);
				preencheTabela(listaAtividades);
				
				
			}
		});

		viea.getBtnInscreverse_Atividade().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				a.setIdAtividade(idLinha);
				aidao.insereAtividadeParticipante(p, a);
				JOptionPane.showMessageDialog(null, "Inscrição feita com sucesso!");


			}
		});

		viea.getBtnCancelar_Atividade().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//criar metodo para apagar inscrição do participante

			}
		});

		viea.getTable_Inscreverse().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(viea.getTable_Inscreverse().getValueAt(linha, 0).toString());
				viea.getBtnInscreverse_Atividade().setEnabled(true);

			}});

	}
	public void preencheTabela(Vector<Vector<String>> listaAtividades){
		viea.getTable_Inscreverse().clearSelection();
		viea.getTable_Inscreverse().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Evento");
		colunas.add("Atividade");
		colunas.add("Vagas");

		DefaultTableModel model = new DefaultTableModel(listaAtividades, colunas);
		viea.getTable_Inscreverse().setModel(model);
		viea.getTable_Inscreverse().getColumn("id").setMaxWidth(25);
	}
}
