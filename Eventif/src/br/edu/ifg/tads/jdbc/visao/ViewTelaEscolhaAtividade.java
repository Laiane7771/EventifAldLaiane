package br.edu.ifg.tads.jdbc.visao;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ViewTelaEscolhaAtividade extends JDialog {
	
	
	private JTextField textField_PesquisarAtividade;
	private JTable table_AtividadeParticipante;
	private JButton btnCheckIn;
	private JButton btnCheckOut;
	private JButton btnVoltar;
	private JLabel lblAtividade;
	private JButton btnPesquisar;
	
	public ViewTelaEscolhaAtividade() {
		
		setTitle("Check In/ Check Out");
		setBounds(100, 100, 735, 466);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField_PesquisarAtividade = new JTextField();
		textField_PesquisarAtividade.setBounds(85, 28, 487, 19);
		panel.add(textField_PesquisarAtividade);
		textField_PesquisarAtividade.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(584, 25, 117, 25);
		panel.add(btnPesquisar);
		
		table_AtividadeParticipante = new JTable();
		table_AtividadeParticipante.setBackground(new Color(50, 205, 50));
		table_AtividadeParticipante.setBounds(12, 59, 564, 351);
		
		table_AtividadeParticipante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table_AtividadeParticipante = new JTable(){@Override
			public boolean isCellEditable(int row, int column) {
			return false;
		}};
		
		btnCheckIn = new JButton("Check In");
		btnCheckIn.setBounds(584, 62, 117, 25);
		panel.add(btnCheckIn);
		
		btnCheckIn.setEnabled(false);
		
		btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBounds(584, 99, 117, 25);
		panel.add(btnCheckOut);
		
		btnCheckOut.setEnabled(false);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(596, 385, 117, 25);
		panel.add(btnVoltar);
		
		lblAtividade = new JLabel("Atividade:");
		lblAtividade.setBounds(12, 30, 87, 15);
		panel.add(lblAtividade);
		
		JScrollPane scrollPane = new JScrollPane(table_AtividadeParticipante);
		scrollPane.setBounds(12, 60, 560, 350);
		panel.add(scrollPane);
		
		this.setVisible(true);
		

	}


	public JTextField getTextField_PesquisarAtividade() {
		return textField_PesquisarAtividade;
	}


	public void setTextField_PesquisarAtividade(
			JTextField textField_PesquisarAtividade) {
		this.textField_PesquisarAtividade = textField_PesquisarAtividade;
	}


	public JTable getTable_AtividadeParticipante() {
		return table_AtividadeParticipante;
	}


	public void setTable_AtividadeParticipante(JTable table_AtividadeParticipante) {
		this.table_AtividadeParticipante = table_AtividadeParticipante;
	}


	


	public JButton getBtnCheckIn() {
		return btnCheckIn;
	}


	public void setBtnCheckIn(JButton btnCheckIn) {
		this.btnCheckIn = btnCheckIn;
	}


	public JButton getBtnCheckOut() {
		return btnCheckOut;
	}


	public void setBtnCheckOut(JButton btnCheckOut) {
		this.btnCheckOut = btnCheckOut;
	}


	public JButton getBtnVoltar() {
		return btnVoltar;
	}


	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}


	public JLabel getLblAtividade() {
		return lblAtividade;
	}


	public void setLblAtividade(JLabel lblAtividade) {
		this.lblAtividade = lblAtividade;
	}


	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}


	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}
	
	
	
	
}
