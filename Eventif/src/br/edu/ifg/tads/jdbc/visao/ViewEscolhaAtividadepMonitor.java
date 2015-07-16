package br.edu.ifg.tads.jdbc.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewEscolhaAtividadepMonitor extends JDialog{

	private JFrame frmEscolhaDoEvento;
	private JTable tableatividade;
	private JButton btnCadastrar;

	
	public ViewEscolhaAtividadepMonitor() {
		
		frmEscolhaDoEvento = new JFrame();
		frmEscolhaDoEvento.setTitle("Escolha da Atividade");
		frmEscolhaDoEvento.setBounds(100, 100, 711, 444);
		frmEscolhaDoEvento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmEscolhaDoEvento.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEscolhaOEvento = new JLabel("Escolha a Atividade:");
		lblEscolhaOEvento.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEscolhaOEvento.setBounds(12, 12, 174, 32);
		panel.add(lblEscolhaOEvento);
		
		tableatividade = new JTable();
		tableatividade.setBackground(new Color(50, 205, 50));
		tableatividade.setBounds(12, 56, 518, 333);
		
		JScrollPane scrollPane = new JScrollPane(tableatividade);
		scrollPane.setBounds(12, 46, 562, 361);
		panel.add(scrollPane);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(580, 67, 117, 25);
		panel.add(btnCadastrar);
	
		this.setVisible(true);
	}


	public JFrame getFrmEscolhaDoEvento() {
		return frmEscolhaDoEvento;
	}


	public void setFrmEscolhaDoEvento(JFrame frmEscolhaDoEvento) {
		this.frmEscolhaDoEvento = frmEscolhaDoEvento;
	}


	public JTable getTableatividade() {
		return tableatividade;
	}


	public void setTableatividade(JTable tableatividade) {
		this.tableatividade = tableatividade;
	}


	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}


	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}
	
	
}
