package br.edu.ifg.tads.jdbc.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class  ViewTelaInicialGerente {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField texpesquisar_evento;
	private JTextField texpesquisar_monitor;
	private JTextField texpesquisar_participante;
	private JButton  btnNovoEvento,btnPesquisarEvento, btnAlterarEvento,buttonExcluirEvento,listar_atividades,
	btnPesquisar_Monitor, btnNovoMonitor,btnPesquisar_participante ;
	private JScrollPane scrollPane;
	private JTable table_eventos;
	private JButton btnLogout;
	private JDesktopPane jdp;
	private JTable table_Monitor_1;
	private JButton btnGerarCrach;
	private JButton btnGerarCertificado;
	private JTable tableParticipante_1;
	private JButton btnGerarTodosCrachs;
	private JButton btnGerarTodosCertificados;

	public  ViewTelaInicialGerente() {
		jdp = new JDesktopPane();
		jdp.setLayout(null);
		frame = new JFrame("Modulo Gerente");
		frame.setContentPane(jdp);
		frame.setBounds(100, 100, 937, 541);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setSize(937,541);
		panel.setBackground(Color.WHITE);
		jdp.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		tabbedPane.setBounds(0, 0, 921, 503);
		panel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Evento", null, panel_1, null);
		panel_1.setLayout(null);

		texpesquisar_evento = new JTextField();
		texpesquisar_evento.setBounds(17, 22, 566, 20);
		panel_1.add(texpesquisar_evento);
		texpesquisar_evento.setColumns(10);

		btnNovoEvento = new JButton("Novo Evento");
		btnNovoEvento.setFont(new Font("URW Chancery L", Font.BOLD, 15));
		btnNovoEvento.setBounds(12, 445, 130, 23);
		panel_1.add(btnNovoEvento);

		btnPesquisarEvento = new JButton("Pesquisar");
		btnPesquisarEvento.setFont(new Font("URW Chancery L", Font.BOLD, 15));
		btnPesquisarEvento.setBounds(595, 20, 117, 23);

		panel_1.add(btnPesquisarEvento);

		btnAlterarEvento = new JButton("Alterar");
		btnAlterarEvento.setFont(new Font("URW Chancery L", Font.BOLD, 13));
		btnAlterarEvento.setBounds(589, 54, 79, 23);
		panel_1.add(btnAlterarEvento);

		buttonExcluirEvento = new JButton("Excluir");
		buttonExcluirEvento.setFont(new Font("URW Chancery L", Font.BOLD, 13));
		buttonExcluirEvento.setBounds(675, 54, 92, 23);
		panel_1.add(buttonExcluirEvento);

		listar_atividades = new JButton("Listar Atividades");
		listar_atividades.setFont(new Font("URW Chancery L", Font.BOLD, 13));
		listar_atividades.setBounds(774, 55, 142, 23);

		panel_1.add(listar_atividades);

		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(Color.GREEN));
		scrollPane.setBounds(12, 54, 573, 379);
		panel_1.add(scrollPane);

		table_eventos = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};

		table_eventos.setBackground(new Color(50, 205, 50));
		scrollPane.setViewportView(table_eventos);

		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("URW Chancery L", Font.BOLD, 15));
		btnLogout.setBounds(790, 441, 114, 23);
		panel_1.add(btnLogout);

		//table_eventos.setCellSelectionEnabled(false);
		table_eventos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//table_eventos.setEditingColumn()

		btnAlterarEvento.setEnabled(false);
		buttonExcluirEvento.setEnabled(false);
		listar_atividades.setEnabled(false);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/laiane/workspace/Eventif/src/br/edu/ifg/tads/jdbc/imagens/nicy.png"));
		lblNewLabel.setBounds(595, 204, 311, 155);
		panel_1.add(lblNewLabel);

		btnGerarTodosCertificados = new JButton("Gerar todos certificados");
		btnGerarTodosCertificados.setBounds(650, 130, 224, 25);
		panel_1.add(btnGerarTodosCertificados);
		
		btnGerarTodosCertificados.setEnabled(false);
	
		btnGerarTodosCrachs = new JButton("Gerar todos Crachás");
		btnGerarTodosCrachs.setBounds(650, 167, 224, 25);
		panel_1.add(btnGerarTodosCrachs);
		
		btnGerarTodosCrachs.setEnabled(false);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Monitor", null, panel_2, null);
		panel_2.setLayout(null);

		texpesquisar_monitor = new JTextField();
		texpesquisar_monitor.setColumns(10);
		texpesquisar_monitor.setBounds(17, 12, 555, 20);
		panel_2.add(texpesquisar_monitor);

		btnPesquisar_Monitor = new JButton("Pesquisar");
		btnPesquisar_Monitor.setFont(new Font("URW Chancery L", Font.BOLD, 15));
		btnPesquisar_Monitor.setBounds(584, 10, 107, 23);
		panel_2.add(btnPesquisar_Monitor);

		btnNovoMonitor = new JButton("Novo Monitor");
		btnNovoMonitor.setFont(new Font("URW Chancery L", Font.BOLD, 15));
		btnNovoMonitor.setBounds(17, 441, 138, 23);
		panel_2.add(btnNovoMonitor);

		table_Monitor_1 = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};
		table_Monitor_1.setBackground(new Color(50, 205, 50));
		table_Monitor_1.setForeground(new Color(0, 0, 0));

		JScrollPane scrollPane_1 = new JScrollPane(table_Monitor_1);
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 255, 0)));
		scrollPane_1.setBounds(17, 44, 555, 385);
		panel_2.add(scrollPane_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("/home/laiane/workspace/Eventif/src/br/edu/ifg/tads/jdbc/imagens/nicy.png"));
		lblNewLabel_2.setBounds(584, 140, 320, 155);
		panel_2.add(lblNewLabel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Participante", null, panel_3, null);
		panel_3.setLayout(null);

		texpesquisar_participante = new JTextField();
		texpesquisar_participante.setColumns(10);
		texpesquisar_participante.setBounds(12, 12, 595, 20);
		panel_3.add(texpesquisar_participante);

		btnPesquisar_participante = new JButton("Pesquisar");
		btnPesquisar_participante.setFont(new Font("URW Chancery L", Font.BOLD, 15));
		btnPesquisar_participante.setBounds(619, 10, 127, 23);
		panel_3.add(btnPesquisar_participante);

		btnGerarCrach = new JButton("Gerar Crachá");
		btnGerarCrach.setFont(new Font("URW Chancery L", Font.BOLD, 15));
		btnGerarCrach.setBounds(617, 45, 129, 25);
		panel_3.add(btnGerarCrach);

		btnGerarCertificado = new JButton("Gerar Certificado");
		btnGerarCertificado.setFont(new Font("URW Chancery L", Font.BOLD, 15));
		btnGerarCertificado.setBounds(619, 82, 155, 25);
		panel_3.add(btnGerarCertificado);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/laiane/workspace/Eventif/src/br/edu/ifg/tads/jdbc/imagens/nicy.png"));
		lblNewLabel_1.setBounds(600, 227, 316, 147);
		panel_3.add(lblNewLabel_1);

		tableParticipante_1 = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};
		tableParticipante_1.setBorder(new LineBorder(Color.GREEN));
		tableParticipante_1.setBackground(new Color(50, 205, 50));

		btnGerarCrach.setEnabled(false);
		btnGerarCertificado.setEnabled(false);

		JScrollPane scrollPane_2 = new JScrollPane(tableParticipante_1);
		scrollPane_2.setBounds(12, 44, 595, 420);
		panel_3.add(scrollPane_2);



		frame.setVisible(true);
		frame.setResizable(false);
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JTextField getTexpesquisar_evento() {
		return texpesquisar_evento;
	}


	public void setTexpesquisar_evento(JTextField texpesquisar_evento) {
		this.texpesquisar_evento = texpesquisar_evento;
	}


	public JTextField getTexpesquisar_monitor() {
		return texpesquisar_monitor;
	}


	public void setTexpesquisar_monitor(JTextField texpesquisar_monitor) {
		this.texpesquisar_monitor = texpesquisar_monitor;
	}


	public JTextField getTexpesquisar_participante() {
		return texpesquisar_participante;
	}


	public void setTexpesquisar_participante(JTextField texpesquisar_participante) {
		this.texpesquisar_participante = texpesquisar_participante;
	}


	public JButton getBtnNovoEvento() {
		return btnNovoEvento;
	}


	public void setBtnNovoEvento(JButton btnNovoEvento) {
		this.btnNovoEvento = btnNovoEvento;
	}


	public JButton getBtnPesquisarEvento() {
		return btnPesquisarEvento;
	}


	public void setBtnPesquisarEvento(JButton btnPesquisarEvento) {
		this.btnPesquisarEvento = btnPesquisarEvento;
	}


	public JButton getBtnAlterarEvento() {
		return btnAlterarEvento;
	}


	public void setBtnAlterarEvento(JButton btnAlterarEvento) {
		this.btnAlterarEvento = btnAlterarEvento;
	}


	public JButton getButtonExcluirEvento() {
		return buttonExcluirEvento;
	}


	public void setButtonExcluirEvento(JButton buttonExcluirEvento) {
		this.buttonExcluirEvento = buttonExcluirEvento;
	}


	public JButton getListar_atividades() {
		return listar_atividades;
	}


	public void setListar_atividades(JButton listar_atividades) {
		this.listar_atividades = listar_atividades;
	}


	public JButton getBtnPesquisar_Monitor() {
		return btnPesquisar_Monitor;
	}


	public void setBtnPesquisar_Monitor(JButton btnPesquisar_Monitor) {
		this.btnPesquisar_Monitor = btnPesquisar_Monitor;
	}


	public JButton getBtnNovoMonitor() {
		return btnNovoMonitor;
	}


	public void setBtnNovoMonitor(JButton btnNovoMonitor) {
		this.btnNovoMonitor = btnNovoMonitor;
	}


	public JButton getBtnPesquisar_participante() {
		return btnPesquisar_participante;
	}


	public void setBtnPesquisar_participante(JButton btnPesquisar_participante) {
		this.btnPesquisar_participante = btnPesquisar_participante;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	public JTable getTable_eventos() {
		return table_eventos;
	}


	public void setTable_eventos(JTable table_eventos) {
		this.table_eventos = table_eventos;
	}


	public JButton getBtnLogout() {
		return btnLogout;
	}


	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}


	public JDesktopPane getJdp() {
		return jdp;
	}


	public void setJdp(JDesktopPane jdp) {
		this.jdp = jdp;
	}


	public JTable getTableParticipante() {
		return tableParticipante_1;
	}


	public void setTableParticipante(JTable tableParticipante) {
		this.tableParticipante_1 = tableParticipante;
	}


	public JTable getTable_Monitor() {
		return table_Monitor_1;
	}


	public void setTable_Monitor(JTable table_Monitor) {
		this.table_Monitor_1 = table_Monitor;
	}


	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}


	public JButton getBtnGerarCrach() {
		return btnGerarCrach;
	}


	public void setBtnGerarCrach(JButton btnGerarCrach) {
		this.btnGerarCrach = btnGerarCrach;
	}


	public JButton getBtnGerarCertificado() {
		return btnGerarCertificado;
	}


	public void setBtnGerarCertificado(JButton btnGerarCertificado) {
		this.btnGerarCertificado = btnGerarCertificado;
	}


	public JTable getTable_Monitor_1() {
		return table_Monitor_1;
	}


	public void setTable_Monitor_1(JTable table_Monitor_1) {
		this.table_Monitor_1 = table_Monitor_1;
	}


	public JTable getTableParticipante_1() {
		return tableParticipante_1;
	}


	public void setTableParticipante_1(JTable tableParticipante_1) {
		this.tableParticipante_1 = tableParticipante_1;
	}


	public JButton getBtnGerarTodosCrachs() {
		return btnGerarTodosCrachs;
	}


	public void setBtnGerarTodosCrachs(JButton btnGerarTodosCrachs) {
		this.btnGerarTodosCrachs = btnGerarTodosCrachs;
	}


	public JButton getBtnGerarTodosCertificados() {
		return btnGerarTodosCertificados;
	}


	public void setBtnGerarTodosCertificados(JButton btnGerarTodosCertificados) {
		this.btnGerarTodosCertificados = btnGerarTodosCertificados;
	}



}

