package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import br.edu.ifg.tads.jdbc.dao.CertificadoDao;
import br.edu.ifg.tads.jdbc.dao.CrachaDao;
import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicialGerente;

public class ControleTelaInicialGerenteParticipante {

	private Participante p;
	private ParticipanteDao pdao = new ParticipanteDao();
	private CertificadoDao cDao = new CertificadoDao();
	private CrachaDao crDao = new CrachaDao();
	private ViewTelaInicialGerente vtig;
	private int idLinha;

	public ControleTelaInicialGerenteParticipante(ViewTelaInicialGerente vtig, Participante p){
		this.p = p;
		this.vtig = vtig;
		preencheTabela(pdao.buscaParticipantes());
		adicionaEventos();
	}

	public void adicionaEventos(){

		vtig.getBtnPesquisar_participante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Participante p = new Participante();
				p.getPessoa().setNomePessoa(vtig.getTexpesquisar_participante().getText());
				Vector<Vector<String>> listaParticipantes = pdao.buscaParticipanteNome(p);
				preencheTabela(listaParticipantes);

			}
		});

		vtig.getBtnGerarCrach().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				GeraCracha();
			}
		});

		vtig.getBtnGerarCertificado().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GeraCertificado();

			}
		});


		vtig.getTableParticipante().addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(vtig.getTableParticipante().getValueAt(linha, 0).toString());
				vtig.getBtnGerarCrach().setEnabled(true);
				vtig.getBtnGerarCertificado().setEnabled(true);

			}
		});

	}

	public void preencheTabela(Vector<Vector<String>> listaParticipantes){
		vtig.getTableParticipante().clearSelection();
		vtig.getTableParticipante().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Nome");
		colunas.add("Evento");

		DefaultTableModel model = new DefaultTableModel(listaParticipantes, colunas);
		vtig.getTableParticipante().setModel(model);
		vtig.getTableParticipante().getColumn("id").setMaxWidth(25);
	}

	public void GeraCertificado(){
		System.out.println("Gerando Certificado...");
		try {
			JasperReport report = JasperCompileManager
					.compileReport("Certificados/NovoCertificados1.jrxml");
			
			JasperPrint print = JasperFillManager.fillReport(report, null,
					new JRBeanCollectionDataSource(cDao.buscaDadosParaCertificado(1)));

			// exportacao do relatorio para outro formato, no caso PDF
			JasperExportManager.exportReportToPdfFile(print,
					"Certificados/NovoCertificados1.pdf");

			JasperViewer.viewReport(print, false);

			System.out.println("Certificado Gerado!");

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void GeraCracha(){
		System.out.println("Gerando Crachá...");
		JOptionPane.showMessageDialog(null, "Gerando Crachá...");
		try{
			JasperReport report = JasperCompileManager
					.compileReport("Cracha/Cracha1.jrxml");
			
			JasperPrint print = JasperFillManager.fillReport(report, null,
					new JRBeanCollectionDataSource(crDao.buscaDadosParaCracha(idLinha)));
			
			JasperExportManager.exportReportToPdfFile(print,
					"Cracha/Cracha1.pdf");
			
			System.out.println("Crachá Gerado!");
			JOptionPane.showMessageDialog(null, "Crachá Gerado!");
			JasperViewer.viewReport(print, false);
		}catch(JRException e){
			e.printStackTrace();
			
		}
	}
}

