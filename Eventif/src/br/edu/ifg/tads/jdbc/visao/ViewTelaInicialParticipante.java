package br.edu.ifg.tads.jdbc.visao;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class ViewTelaInicialParticipante {

	private JFrame frmAmbienteParticipante;
	private JTextField textField_pesquisar;
	private JButton btnPesquisar;
	private JButton btnAcessar;
	private JButton btnLogout;
	private JButton btnAlterarDados;
	private JTable tableParticipante_evento;
	private JTable tableParticipante_evento_1;
	private JDesktopPane jdp;
	private JButton btnVerAtividadesEscolhidas;

	public ViewTelaInicialParticipante() {

		jdp = new JDesktopPane();
		jdp.setLayout(null);
		frmAmbienteParticipante = new JFrame("Participate");
		frmAmbienteParticipante.setContentPane(jdp);
		frmAmbienteParticipante.setTitle("Ambiente Participante\n");
		frmAmbienteParticipante.setBounds(100, 100, 937, 541);
		frmAmbienteParticipante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setSize(937, 541);
		panel.setBackground(Color.WHITE);
		jdp.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField_pesquisar = new JTextField();
		textField_pesquisar.setBounds(81, 38, 482, 20);
		panel.add(textField_pesquisar);
		textField_pesquisar.setColumns(10);

		JLabel lblEventos = new JLabel("Evento:");
		lblEventos.setBounds(24, 40, 59, 14);
		panel.add(lblEventos);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(575, 36, 122, 23);
		panel.add(btnPesquisar);

		btnAcessar = new JButton("Acessar");
		btnAcessar.setBounds(575, 71, 122, 23);
		panel.add(btnAcessar);

		btnAcessar.setEnabled(false);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(575, 463, 124, 23);
		panel.add(btnLogout);

		tableParticipante_evento = new JTable();
		tableParticipante_evento.setBackground(new Color(50, 205, 50));
		tableParticipante_evento.setBounds(22, 42, 733, 433);

		tableParticipante_evento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableParticipante_evento_1 = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};
		tableParticipante_evento_1.setBorder(new LineBorder(new Color(0, 255, 0)));
		tableParticipante_evento_1.setBackground(new Color(50, 205, 50));
		JScrollPane scrollPane = new JScrollPane(tableParticipante_evento_1);
		scrollPane.setBounds(24, 66, 539, 420);
		panel.add(scrollPane);
		
		btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.setBounds(575, 426, 132, 25);
		panel.add(btnAlterarDados);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/laiane/workspace/Eventif/src/br/edu/ifg/tads/jdbc/imagens/nicy.png"));
		lblNewLabel.setBounds(576, 156, 319, 162);
		panel.add(lblNewLabel);
		
		btnVerAtividadesEscolhidas = new JButton("Ver Atividades Escolhidas");
		btnVerAtividadesEscolhidas.setBounds(575, 389, 215, 25);
		panel.add(btnVerAtividadesEscolhidas);

		frmAmbienteParticipante.setVisible(true);
		frmAmbienteParticipante.setResizable(false);

	}
	public JFrame getFrame() {
		return frmAmbienteParticipante;
	}

	public void setFrame(JFrame frame) {
		this.frmAmbienteParticipante = frame;
	}

	public JTextField getTextField_pesquisar() {
		return textField_pesquisar;
	}

	public void setTextField_pesquisar(JTextField textField_pesquisar) {
		this.textField_pesquisar = textField_pesquisar;
	}

	public JTable getTable() {
		return getTable();
	}

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}


	public JButton getBtnAcessar() {
		return btnAcessar;
	}


	public void setBtnAcessar(JButton btnAcessar) {
		this.btnAcessar = btnAcessar;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}
	public JFrame getFrmAmbienteParticipante() {
		return frmAmbienteParticipante;
	}
	public void setFrmAmbienteParticipante(JFrame frmAmbienteParticipante) {
		this.frmAmbienteParticipante = frmAmbienteParticipante;
	}
	public JTable getTableParticipante_evento() {
		return tableParticipante_evento_1;
	}
	public void setTableParticipante_evento(JTable tableParticipante_evento) {
		this.tableParticipante_evento_1 = tableParticipante_evento;
	}
	public JDesktopPane getJdp() {
		return jdp;
	}
	public void setJdp(JDesktopPane jdp) {
		this.jdp = jdp;
	}
	public JButton getBtnAlterarDados() {
		return btnAlterarDados;
	}
	public void setBtnAlterarDados(JButton btnAlterarDados) {
		this.btnAlterarDados = btnAlterarDados;
	}
	public JTable getTableParticipante_evento_1() {
		return tableParticipante_evento_1;
	}
	public void setTableParticipante_evento_1(JTable tableParticipante_evento_1) {
		this.tableParticipante_evento_1 = tableParticipante_evento_1;
	}
	public JButton getBtnVerAtividadesEscolhidas() {
		return btnVerAtividadesEscolhidas;
	}
	public void setBtnVerAtividadesEscolhidas(JButton btnVerAtividadesEscolhidas) {
		this.btnVerAtividadesEscolhidas = btnVerAtividadesEscolhidas;
	}

}

