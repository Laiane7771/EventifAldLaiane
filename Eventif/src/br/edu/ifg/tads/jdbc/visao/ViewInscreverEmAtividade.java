package br.edu.ifg.tads.jdbc.visao;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.Color;


public class ViewInscreverEmAtividade extends JInternalFrame {

	private JTextField textField_Inscrever;
	private JButton btnPequisar_atividade;
	private JButton btnInscreverse_Atividade;
	private JButton btnCancelar_Atividade;
	private JButton btnVoltar_Atividade;
	private JTable table_Inscreverse;

	public ViewInscreverEmAtividade() {
		setTitle("Inscrever - se em Atividade");
		setBounds(100, 100, 735, 466);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		getContentPane().add(panel);
		panel.setSize(735,466);

		JLabel lblEvento = new JLabel("Atividade: ");
		lblEvento.setBounds(12, 27, 83, 18);
		panel.add(lblEvento);

		textField_Inscrever = new JTextField();
		textField_Inscrever.setBounds(89, 27, 493, 20);
		panel.add(textField_Inscrever);
		textField_Inscrever.setColumns(10);

		btnPequisar_atividade = new JButton("Pesquisar");
		btnPequisar_atividade.setBounds(594, 22, 119, 23);
		panel.add( btnPequisar_atividade);

		btnInscreverse_Atividade = new JButton("Inscrever-se");
		btnInscreverse_Atividade.setBounds(594, 57, 128, 23);
		panel.add(btnInscreverse_Atividade);


		btnCancelar_Atividade = new JButton("Cancelar");
		btnCancelar_Atividade.setBounds(804, 98, 107, 23);
		panel.add(btnCancelar_Atividade);

		table_Inscreverse = new JTable();
		table_Inscreverse.setBackground(new Color(50, 205, 50));
		table_Inscreverse.setBounds(12, 57, 570, 354);

		table_Inscreverse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table_Inscreverse = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};

		JScrollPane scrollPane = new JScrollPane(table_Inscreverse);
		scrollPane.setBounds(12, 57, 570, 354);
		panel.add(scrollPane);

		btnInscreverse_Atividade.setEnabled(false);

		this.setVisible(true);
		this.setClosable(true);

	}

	

	public JTextField getTextField_Inscrever() {
		return textField_Inscrever;
	}



	public void setTextField_Inscrever(JTextField textField_Inscrever) {
		this.textField_Inscrever = textField_Inscrever;
	}



	public JButton getBtnPequisar_atividade() {
		return btnPequisar_atividade;
	}

	public void setBtnPequisar_atividade(JButton btnPequisar_atividade) {
		this.btnPequisar_atividade = btnPequisar_atividade;
	}

	public JButton getBtnInscreverse_Atividade() {
		return btnInscreverse_Atividade;
	}

	public void setBtnInscreverse_Atividade(JButton btnInscreverse_Atividade) {
		this.btnInscreverse_Atividade = btnInscreverse_Atividade;
	}


	public JButton getBtnCancelar_Atividade() {
		return btnCancelar_Atividade;
	}

	public void setBtnCancelar_Atividade(JButton btnCancelar_Atividade) {
		this.btnCancelar_Atividade = btnCancelar_Atividade;
	}

	public JButton getBtnVoltar_Atividade() {
		return btnVoltar_Atividade;
	}

	public void setBtnVoltar_Atividade(JButton btnVoltar_Atividade) {
		this.btnVoltar_Atividade = btnVoltar_Atividade;
	}

	public JTable getTable_Inscreverse() {
		return table_Inscreverse;
	}

	public void setTable_Inscreverse(JTable table_Inscreverse) {
		this.table_Inscreverse = table_Inscreverse;
	}


}
