package br.edu.ifg.tads.jdbc.visao;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;


public class ViewExibeAtividades extends JInternalFrame {
	
	private JTable tableMostraAtividade;
	private JButton btnCancelar;

	
	public ViewExibeAtividades() {
		//setBorder(new LineBorder(Color.GREEN));
		setTitle("Atividades Escolhidas");
		setClosable(true);
		setBounds(100, 100, 711, 444);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tableMostraAtividade = new JTable();
		tableMostraAtividade.setBackground(Color.GREEN);
		tableMostraAtividade.setBounds(12, 12, 518, 396);
	
		
		JScrollPane scrollPane = new JScrollPane(tableMostraAtividade);
		scrollPane.setBounds(12, 26, 509, 374);
		panel.add(scrollPane);
		
		this.setClosable(true);
		this.setVisible(true);
	

	}

	public JTable getTableMostraAtividade() {
		return tableMostraAtividade;
	}

	public void setTableMostraAtividade(JTable tableMostraAtividade) {
		this.tableMostraAtividade = tableMostraAtividade;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}


}
