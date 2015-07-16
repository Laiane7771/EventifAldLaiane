package br.edu.ifg.tads.jdbc.visao;

import java.awt.EventQueue;

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

public class ViewListaEvento {

	private JFrame frame;
	private JTable tableListaEvento;
	private JTextField textFieldPesquisaEvento;
	private JButton btnPesquisar;
	private JButton btnVoltar;
	private JButton btnPrximo;

	public ViewListaEvento() {

		frame = new JFrame("Passo 2");
		frame.setBounds(100, 100, 711, 444);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);



		tableListaEvento = new JTable();
		tableListaEvento.setBackground(new Color(50, 205, 50));
		tableListaEvento.setBounds(23, 69, 480, 324);
		tableListaEvento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableListaEvento = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};

		textFieldPesquisaEvento = new JTextField();
		textFieldPesquisaEvento.setBounds(22, 38, 481, 19);
		panel.add(textFieldPesquisaEvento);
		textFieldPesquisaEvento.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(515, 35, 117, 25);
		panel.add(btnPesquisar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(515, 368, 117, 25);
		panel.add(btnVoltar);

		JLabel lblEscolhaOEvento = new JLabel("Escolha o Evento:");
		lblEscolhaOEvento.setBounds(26, 12, 172, 15);
		panel.add(lblEscolhaOEvento);

		btnPrximo = new JButton("Próximo");
		btnPrximo.setBounds(515, 80, 117, 25);
		panel.add(btnPrximo);

		JScrollPane scrollPane = new JScrollPane(tableListaEvento);
		scrollPane.setBounds(23, 69, 486, 324);
		panel.add(scrollPane);

		frame.setVisible(true);
		frame.setResizable(false);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTable getTableListaEvento() {
		return tableListaEvento;
	}

	public void setTableListaEvento(JTable tableListaEvento) {
		this.tableListaEvento = tableListaEvento;
	}

	public JTextField getTextFieldPesquisaEvento() {
		return textFieldPesquisaEvento;
	}

	public void setTextFieldPesquisaEvento(JTextField textFieldPesquisaEvento) {
		this.textFieldPesquisaEvento = textFieldPesquisaEvento;
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

	public JButton getBtnPrximo() {
		return btnPrximo;
	}

	public void setBtnPrximo(JButton btnPrximo) {
		this.btnPrximo = btnPrximo;
	}


}
