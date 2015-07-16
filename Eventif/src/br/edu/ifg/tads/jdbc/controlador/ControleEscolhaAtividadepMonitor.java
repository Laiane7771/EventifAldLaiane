package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.edu.ifg.tads.jdbc.dao.AtividadeDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Monitor;
import br.edu.ifg.tads.jdbc.visao.ViewEscolhaAtividadepMonitor;

public class ControleEscolhaAtividadepMonitor {

	private ViewEscolhaAtividadepMonitor veam;
	private Monitor m;
	private Atividade a;
	private AtividadeDao aDao = new AtividadeDao();
	private int idLinha;

	public ControleEscolhaAtividadepMonitor(ViewEscolhaAtividadepMonitor veam){
		this.veam = veam;

	}

	public void adicionaEventos(){
		veam.getBtnCadastrar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//a.setIdAtividade(idLinha);
			//	aDao.insereMonitorAtivi(m, a);
				//JOptionPane.showMessageDialog(null, "Inscrição feita com sucesso!");

			}
		});
		
		veam.getTableatividade().addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(veam.getTableatividade().getValueAt(linha, 0).toString());
				veam.getBtnCadastrar().setEnabled(true);
			}
		});
	}

}
