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

public class ViewListaTodosAlunos {

	private JFrame frame;
	private JTable tableListaAluno;
	private JTextField textFieldPesquisar;
	private JButton btnVoltar;
	private JButton btnPesquisar;
	private JButton btnProximo;

	public ViewListaTodosAlunos() {

		frame = new JFrame("Passo 1");
		frame.setBounds(100, 100, 711, 444);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tableListaAluno = new JTable();
		tableListaAluno.setBackground(new Color(50, 205, 50));
		tableListaAluno.setBounds(26, 63, 508, 331);
		
		tableListaAluno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableListaAluno = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};
		
		textFieldPesquisar = new JTextField();
		textFieldPesquisar.setBounds(26, 32, 508, 19);
		panel.add(textFieldPesquisar);
		textFieldPesquisar.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(546, 29, 117, 25);
		panel.add(btnPesquisar);
		
		btnProximo = new JButton("Próximo");
		btnProximo.setBounds(546, 81, 117, 25);
		panel.add(btnProximo);
		
		btnProximo.setEnabled(false);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(546, 369, 117, 25);
		panel.add(btnVoltar);
		
		JLabel lblEscolhaOAluno = new JLabel("Escolha o aluno para ser Monitor:");
		lblEscolhaOAluno.setBounds(26, 5, 285, 25);
		panel.add(lblEscolhaOAluno);
		
		JScrollPane scrollPane = new JScrollPane(tableListaAluno);
		scrollPane.setBounds(26, 63, 508, 331);
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

	public JTable getTableListaAluno() {
		return tableListaAluno;
	}

	public void setTableListaAluno(JTable tableListaAluno) {
		this.tableListaAluno = tableListaAluno;
	}

	
	public JTextField getTextFieldPesquisar() {
		return textFieldPesquisar;
	}

	public void setTextFieldPesquisar(JTextField textFieldPesquisar) {
		this.textFieldPesquisar = textFieldPesquisar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}

	public JButton getBtnProximo() {
		return btnProximo;
	}

	public void setBtnProximo(JButton btnProximo) {
		this.btnProximo = btnProximo;
	}
	
}
	

