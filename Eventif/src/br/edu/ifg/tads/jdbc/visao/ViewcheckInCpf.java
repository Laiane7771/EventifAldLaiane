package br.edu.ifg.tads.jdbc.visao;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewcheckInCpf extends JInternalFrame {
	
	private JTextField textField;
	private JButton btnEnviar;


	public ViewcheckInCpf() {
		
		
		setTitle("Check In/ Check Out");
		setBounds(100, 100, 735, 466);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(90, 194, 200, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCc = new JLabel("CPF:");
		lblCc.setBounds(54, 196, 40, 15);
		panel.add(lblCc);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(184, 259, 99, 19);
		panel.add(btnEnviar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/laiane/workspace/Eventif/src/br/edu/ifg/tads/jdbc/imagens/nicy.png"));
		lblNewLabel.setBounds(355, 144, 321, 167);
		panel.add(lblNewLabel);
		
		this.setClosable(true);
		this.setVisible(true);

	}


	public JTextField getTextField() {
		return textField;
	}


	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	public JButton getBtnEnviar() {
		return btnEnviar;
	}


	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}
	
}
