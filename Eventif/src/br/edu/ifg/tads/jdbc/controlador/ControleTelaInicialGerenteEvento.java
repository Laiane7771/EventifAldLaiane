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
import br.edu.ifg.tads.jdbc.dao.EventoDao;
import br.edu.ifg.tads.jdbc.dao.GerenteDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.modelo.Gerente;
import br.edu.ifg.tads.jdbc.visao.ViewAlteraEvento;
import br.edu.ifg.tads.jdbc.visao.ViewCadastrarNovoEvento;
import br.edu.ifg.tads.jdbc.visao.ViewListaAtividades;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicialGerente;


public class ControleTelaInicialGerenteEvento {

	private ViewTelaInicialGerente vtig;
	private Gerente g;
	private GerenteDao gd;
	private EventoDao eDao = new EventoDao();
	private CertificadoDao cDao = new CertificadoDao();
	private CrachaDao crDao = new CrachaDao();
	private ViewCadastrarNovoEvento vcne;
	private int idLinha;

	public ControleTelaInicialGerenteEvento(ViewTelaInicialGerente vtig, Gerente g, GerenteDao gd, ViewCadastrarNovoEvento vcne){
		this.vtig = vtig;
		this.g = g;
		this.gd = gd;
		this.vcne = vcne;
		adicionaEventos();
		preencheTabela(eDao.buscaEventos(idLinha));

	}

	public void adicionaEventos(){


		vtig.getBtnPesquisarEvento().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Evento e = new Evento();
				e.setNomeEvento(vtig.getTexpesquisar_evento().getText());
				Vector<Vector<String>> listaEventos = eDao.buscaEventoNome(e);
				preencheTabela(listaEventos);

			}
		});

		vtig.getBtnAlterarEvento().addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				int index = vtig.getTable_eventos().getSelectedRow();
				int id = Integer.parseInt(vtig.getTable_eventos().getValueAt(index, 0).toString());
				Evento et = new Evento();
				et.setIdEvento(id);
				Evento bc = eDao.buscaEvento(et);
				ViewAlteraEvento vae = new ViewAlteraEvento();
				new ControleAlteraEvento(vae,bc,eDao,ControleTelaInicialGerenteEvento.this);
				vtig.getJdp().add(vae);
				vtig.getJdp().moveToFront(vae);

			}
		});

		vtig.getButtonExcluirEvento().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = vtig.getTable_eventos().getSelectedRow();
				int id = Integer.parseInt(vtig.getTable_eventos().getValueAt(index, 0).toString());
				Evento et = new Evento();
				et.setIdEvento(id);
				Evento bc = eDao.buscaEvento(et);
				int r = JOptionPane.showConfirmDialog( vcne, "Realmente deseja excluir o Evento " + bc.getNomeEvento() + "?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION );
				if(r==0){
					eDao.remove(bc);
					preencheTabela(eDao.buscaEventos(idLinha));
				}
			}

		});

		vtig.getListar_atividades().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				instanciaListadeAtividades();
			}
		});

		vtig.getBtnNovoEvento().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent novoEvento) {
				instanciaNovoEvento();
			}
		}); 

		vtig.getBtnLogout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				vtig.getFrame().dispose();
			}
		});
		//gerar todos crachas
		vtig.getBtnGerarTodosCertificados().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GeraTodosCertificado();
			}
		});

		vtig.getBtnGerarTodosCrachs().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GeraTodosCracha();
			}
		});

		//gerar todos certificados;
		vtig.getTable_eventos().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(vtig.getTable_eventos().getValueAt(linha, 0).toString());
				vtig.getBtnAlterarEvento().setEnabled(true);
				vtig.getButtonExcluirEvento().setEnabled(true);
				vtig.getListar_atividades().setEnabled(true);
				vtig.getBtnGerarTodosCertificados().setEnabled(true);
				vtig.getBtnGerarTodosCrachs().setEnabled(true);
			}
		});
	}

	//Metodos======================================================================================================
	//Lista de Atividades
	public void instanciaListadeAtividades(){
		ViewListaAtividades vla = new ViewListaAtividades();
		Atividade a = new Atividade();
		ControleListaAtividades cla = new ControleListaAtividades(vla, a, idLinha);
		vtig.getJdp().add(vla);
		vtig.getJdp().moveToFront(vla);

	}
	//Tela de novo evento
	public void instanciaNovoEvento(){

		ViewCadastrarNovoEvento vcne = new ViewCadastrarNovoEvento();
		Evento e = new Evento();
		ControleCadastrarNovoEvento ccne = new ControleCadastrarNovoEvento(vcne, e, this);
		vtig.getJdp().add(vcne);
		vtig.getJdp().moveToFront(vcne);

	}
	public void preencheTabela(){

		preencheTabela(eDao.buscaEventos(idLinha));
	}

	public void preencheTabela(Vector<Vector<String>> listaEventos){
		vtig.getTable_eventos().clearSelection();
		vtig.getTable_eventos().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Nome");
		colunas.add("Organizador(a)");
		colunas.add("Descrição");

		DefaultTableModel model = new DefaultTableModel(listaEventos, colunas);
		vtig.getTable_eventos().setModel(model);
		vtig.getTable_eventos().getColumn("id").setMaxWidth(25);
	}


	public void GeraTodosCertificado(){
		System.out.println("Gerando Certificado...");
		JOptionPane.showMessageDialog(null, "Gerando Certificado!");
		try {
			JasperReport report = JasperCompileManager
					.compileReport("Certificados/NovoCertificados.jrxml");

			JasperReport report1 = JasperCompileManager
					.compileReport("Certificados/NovoCertificados_subreport1.jrxml");
			
			Map parametros = new HashMap();
			parametros.put("NovoCertificados_subreport1", "Certificados/NovoCertificados_subreport1.jrxml");

			JasperPrint print = JasperFillManager.fillReport(report, null,
					new JRBeanCollectionDataSource(cDao.buscaDadosParaTodosCertificado(idLinha)));

			// exportacao do relatorio para outro formato, no caso PDF
			JasperExportManager.exportReportToPdfFile(print,
					"Certificados/NovoCertificados.pdf");


			System.out.println("Certificado Gerado!");
			JOptionPane.showMessageDialog(null, "Certificado Gerado!");
			JasperViewer.viewReport(print, false);

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void GeraTodosCracha(){
		System.out.println("Gerando Crachá...");
		JOptionPane.showMessageDialog(null, "Gerando Crachá!");
		try {
			JasperReport report = JasperCompileManager
					.compileReport("Cracha/Cracha.jrxml");

			JasperPrint print = JasperFillManager.fillReport(report, null,
					new JRBeanCollectionDataSource(crDao.buscaDadosParaTodosCracha()));

			// exportacao do relatorio para outro formato, no caso PDF
			JasperExportManager.exportReportToPdfFile(print,
					"Cracha/Cracha.pdf");


			System.out.println("Crachá Gerado!");
			JOptionPane.showMessageDialog(null, "Crachá Gerado!");
			JasperViewer.viewReport(print, false);

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
