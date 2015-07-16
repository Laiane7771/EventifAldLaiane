package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;
import br.edu.ifg.tads.jdbc.dao.PresencaDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Presenca;
import br.edu.ifg.tads.jdbc.visao.ViewTelaEscolhaAtividade;

public class ControleTelaEscolhaAtividade {
	
	private ViewTelaEscolhaAtividade vtea;
	private ParticipanteDao pDao = new ParticipanteDao();
	private Presenca pre;
	private Participante p;
	private int idLinha;
	private Atividade a = new Atividade();
    private PresencaDao psdao = new PresencaDao();
    private int idAtividade;
    private int idParticipante;
	
	public ControleTelaEscolhaAtividade(ViewTelaEscolhaAtividade vtea, Participante p,int idLinha,Presenca pre){
		this.vtea = vtea;
		this.p = p;
		this.idLinha = idLinha;
		
		adicionaEventos();
		preencheTabela(pDao.ExibeAtividadeParticipante(p.getIdParticipante()));
	}
	
	public void adicionaEventos(){
		
		vtea.getBtnCheckIn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*
			  ViewPresencaEntrada vpe = new ViewPresencaEntrada();
			  Presenca pre = new Presenca();
			  ControlePresencaEntrada cpe = new ControlePresencaEntrada(vpe,p,idLinha,pre);
			  */
				a.setIdAtividade(idLinha);
				psdao.insiraEntrada( pre,p, a);
				JOptionPane.showMessageDialog(null, "O CHECKIN foi executado com sucesso!");
		
						
			}
		});
		
		vtea.getBtnCheckOut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*
				ViewPresencaSaida vps = new ViewPresencaSaida();
				Presenca pre = new Presenca();
				ControlePresencaSaida cps = new ControlePresencaSaida(vps,p,idLinha,pre);
				*/
				a.setIdAtividade(idLinha);
				psdao.insiraSaida(pre, p, a);
				JOptionPane.showMessageDialog(null, "O CHECkout foi executado com sucesso!");
		
				
			}
		});
		
		vtea.getBtnVoltar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vtea.dispose();
			}
		});
		vtea.getTable_AtividadeParticipante().addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(vtea.getTable_AtividadeParticipante().getValueAt(linha, 0).toString());
				vtea.getBtnCheckIn().setEnabled(true);
				vtea.getBtnCheckOut().setEnabled(true);

			}
		});
	}
	
	public void preencheTabela(Vector<Vector<String>> listaAtividades){
		vtea.getTable_AtividadeParticipante().clearSelection();
		vtea.getTable_AtividadeParticipante().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Nome");
		colunas.add("Hora Início");
		colunas.add("Hora Encerramento");
		
		DefaultTableModel model = new DefaultTableModel(listaAtividades, colunas);
		vtea.getTable_AtividadeParticipante().setModel(model);
		vtea.getTable_AtividadeParticipante().getColumn("id").setMaxWidth(25);
	}

}
