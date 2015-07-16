package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.jdbc.dao.AtividadeDao;
import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.visao.ViewExibeAtividades;

public class ControleExibeAtividades {
	
	private ViewExibeAtividades veas;
	private ParticipanteDao pDao = new ParticipanteDao();
	private Participante p = new Participante();
	private int idLinha;
	
	public ControleExibeAtividades(ViewExibeAtividades veas, int idLinha){
		this.veas = veas;
		this.idLinha = idLinha;
		preencheTabela(pDao.ExibeAtividadeParticipante(idLinha));
		System.out.println(p.getIdParticipante());
		
	}
	public void adicionaEventos(){
		
		veas.getBtnCancelar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				//criar metodo para apagar inscrição da atividade
			}
		});
		veas.getTableMostraAtividade().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(veas.getTableMostraAtividade().getValueAt(linha, 0).toString());
				veas.getTableMostraAtividade().setEnabled(true);
				
			}
		});
	
	}
	
	public void preencheTabela(Vector<Vector<String>> listaAtividades){
		veas.getTableMostraAtividade().clearSelection();
		veas.getTableMostraAtividade().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Nome");
		colunas.add("Hora Início");
		colunas.add("Hora Encerramento");
		
		DefaultTableModel model = new DefaultTableModel(listaAtividades, colunas);
		veas.getTableMostraAtividade().setModel(model);
		veas.getTableMostraAtividade().getColumn("id").setMaxWidth(25);
	}
}
