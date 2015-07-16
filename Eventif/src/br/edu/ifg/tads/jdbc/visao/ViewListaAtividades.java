package br.edu.ifg.tads.jdbc.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class ViewListaAtividades extends JInternalFrame{
	
	
	private JTextField textField;
	private JTable table_ListaAtividades;
	private JButton btnNewButtonPesquisar;
	private JButton btnAlterar;
	private JButton btnNewButtonExcluir;
	private JButton btnNovaAtividade;
	private JScrollPane scrollPane;
	
	public ViewListaAtividades() {
		
		setTitle("Lista de Atividades");
		
		setBounds(100, 100, 735, 466);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 18, 532, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButtonPesquisar = new JButton("Pesquisar");
		btnNewButtonPesquisar.setFont(new Font("URW Chancery L", Font.BOLD, 13));
		btnNewButtonPesquisar.setBounds(556, 15, 96, 26);
		panel.add(btnNewButtonPesquisar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("URW Chancery L", Font.BOLD, 13));
		btnAlterar.setBounds(556, 53, 75, 25);
		panel.add(btnAlterar);
		
		btnNewButtonExcluir = new JButton("Excluir");
		btnNewButtonExcluir.setFont(new Font("URW Chancery L", Font.BOLD, 13));
		btnNewButtonExcluir.setBounds(636, 53, 77, 25);
		panel.add(btnNewButtonExcluir);
		
		table_ListaAtividades = new JTable();
		table_ListaAtividades.setBackground(UIManager.getColor("Button.select"));
		table_ListaAtividades.setBounds(12, 50, 532, 333);
		table_ListaAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_ListaAtividades = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};
		btnNovaAtividade = new JButton("Nova Atividade");
		btnNovaAtividade.setFont(new Font("URW Chancery L", Font.BOLD, 15));
		btnNovaAtividade.setBounds(12, 397, 154, 25);
		panel.add(btnNovaAtividade);
		
		scrollPane = new JScrollPane(table_ListaAtividades);
		scrollPane.setBounds(12, 53, 532, 333);
		panel.add(scrollPane);
		
		btnAlterar.setEnabled(false);
		btnNewButtonExcluir.setEnabled(false);
		
		this.setClosable(true);
		this.setVisible(true);

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	

	public JTable getTable_ListaAtividades() {
		return table_ListaAtividades;
	}

	public void setTable_ListaAtividades(JTable table_ListaAtividades) {
		this.table_ListaAtividades = table_ListaAtividades;
	}

	public JButton getBtnNewButton() {
		return btnNovaAtividade;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNovaAtividade = btnNewButton;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton getBtnNewButtonPesquisar() {
		return btnNewButtonPesquisar;
	}

	public void setBtnNewButtonPesquisar(JButton btnNewButtonPesquisar) {
		this.btnNewButtonPesquisar = btnNewButtonPesquisar;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	public void setBtnAlterar(JButton btnAlterar) {
		this.btnAlterar = btnAlterar;
	}

	public JButton getBtnNewButtonExcluir() {
		return btnNewButtonExcluir;
	}

	public void setBtnNewButtonExcluir(JButton btnNewButtonExcluir) {
		this.btnNewButtonExcluir = btnNewButtonExcluir;
	}

	public JButton getBtnNovaAtividade() {
		return btnNovaAtividade;
	}

	public void setBtnNovaAtividade(JButton btnNovaAtividade) {
		this.btnNovaAtividade = btnNovaAtividade;
	}
	
}
