package br.edu.ifg.tads.jdbc.visao;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ViewListaAtividadeMonitor {

	private JFrame frame;
	private JTable tableListaAtividade;
	private JTextField textField;
	private JButton btnPesquisar;
	private JButton btnVoltar;
	private JButton btnFinalizar;

	public ViewListaAtividadeMonitor() {

		frame = new JFrame("Passo 3");
		frame.setBounds(100, 100, 711, 444);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		tableListaAtividade = new JTable();
		tableListaAtividade.setBackground(new Color(50, 205, 50));
		tableListaAtividade.setBounds(24, 70, 499, 320);

		tableListaAtividade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableListaAtividade = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};
		textField = new JTextField();
		textField.setBounds(24, 39, 492, 19);
		panel.add(textField);
		textField.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(528, 36, 117, 25);
		panel.add(btnPesquisar);

		JLabel lblEscolhaAAtividade = new JLabel("Escolha a Atividade:");
		lblEscolhaAAtividade.setBounds(24, 12, 161, 15);
		panel.add(lblEscolhaAAtividade);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(528, 365, 117, 25);
		panel.add(btnVoltar);

		JScrollPane scrollPane = new JScrollPane(tableListaAtividade);
		scrollPane.setBounds(24, 70, 499, 320);
		panel.add(scrollPane);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(528, 88, 117, 25);
		panel.add(btnFinalizar);

		btnFinalizar.setEnabled(false);

		frame.setVisible(true);
		frame.setResizable(false);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTable getTableListaAtividade() {
		return tableListaAtividade;
	}

	public void setTableListaAtividade(JTable tableListaAtividade) {
		this.tableListaAtividade = tableListaAtividade;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public void setBtnFinalizar(JButton btnFinalizar) {
		this.btnFinalizar = btnFinalizar;
	}


}
