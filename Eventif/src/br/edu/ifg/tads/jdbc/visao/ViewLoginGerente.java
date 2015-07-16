package br.edu.ifg.tads.jdbc.visao;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewLoginGerente {
	
	private JFrame frame;
	private JTextField textFieldgerente;
	private JPasswordField passwordFieldGerente;
	private JButton btnLogin;
	private JButton btnVoltar;

	public ViewLoginGerente() {
		
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 937, 541);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 12, 911, 492);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnLogin = new JButton("Login ");
		btnLogin.setBounds(278, 307, 86, 36);
		panel.add(btnLogin);
		
		JLabel lblCpf = new JLabel("CPF/SIAPE:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCpf.setBounds(67, 175, 106, 36);
		panel.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSenha.setBounds(106, 246, 70, 15);
		panel.add(lblSenha);
		
		textFieldgerente = new JTextField();
		textFieldgerente.setBounds(172, 185, 192, 19);
		panel.add(textFieldgerente);
		textFieldgerente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/laiane/Área de Trabalho/TrabalhoIntegrado/Eventif/src/br/edu/ifg/tads/jdbc/imagens/nicy.png"));
		lblNewLabel.setBounds(492, 175, 319, 156);
		panel.add(lblNewLabel);
		
		passwordFieldGerente = new JPasswordField();
		passwordFieldGerente.setBounds(172, 245, 192, 19);
		panel.add(passwordFieldGerente);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(185, 307, 86, 36);
		panel.add(btnVoltar);
		
		frame.setVisible(true);
		frame.setResizable(false);
		
		
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextFieldgerente() {
		return textFieldgerente;
	}


	public void setTextFieldgerente(JTextField textFieldgerente) {
		this.textFieldgerente = textFieldgerente;
	}


	public JPasswordField getPasswordFieldGerente() {
		return passwordFieldGerente;
	}


	public void setPasswordFieldGerente(JPasswordField passwordFieldGerente) {
		this.passwordFieldGerente = passwordFieldGerente;
	}


	public JButton getBtnLogin() {
		return btnLogin;
	}


	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}


	public JButton getBtnVoltar() {
		return btnVoltar;
	}


	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}
	
}



