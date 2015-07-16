	package br.edu.ifg.tads.jdbc.visao;
	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.sql.rowset.Predicate;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
	
	public class ViewTelaInicial{
		
		private JFrame frame = new JFrame();
		private JButton btnNewButtonGerente;
		private JButton btnNewButton_1Monitor;
		private JButton btnNewButton_2jaPar;
		private JButton btnNewButton_3par;
		
		public ViewTelaInicial(){
	
		frame.setBounds(100, 100, 937, 541);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnNewButtonGerente = new JButton("Login");
		btnNewButtonGerente.setBackground(UIManager.getColor("Button.focus"));
		btnNewButtonGerente.setBounds(47, 196, 178, 66);
		panel.add(btnNewButtonGerente);
		
		btnNewButton_1Monitor = new JButton("Login");
		btnNewButton_1Monitor.setBounds(47, 294, 178, 66);
		panel.add(btnNewButton_1Monitor);
		
		btnNewButton_2jaPar = new JButton("Já possuo Cadastro");
		btnNewButton_2jaPar.setBounds(667, 193, 178, 66);
		panel.add(btnNewButton_2jaPar);
		
		btnNewButton_3par = new JButton("Quero me cadastrar");
		btnNewButton_3par.setBounds(667, 288, 178, 72);
		panel.add(btnNewButton_3par);
		
		JLabel lblNewLabel = new JLabel("Gerente");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(52, 159, 102, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Monitor");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(47, 269, 148, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblParticipante = new JLabel("Participante");
		lblParticipante.setFont(new Font("Dialog", Font.BOLD, 20));
		lblParticipante.setBounds(673, 168, 155, 17);
		panel.add(lblParticipante);
		
		JLabel lblNewLabel_2 = new JLabel("aqui");
		lblNewLabel_2.setIcon(new ImageIcon("/home/laiane/Área de Trabalho/TrabalhoIntegrado/Eventif/src/br/edu/ifg/tads/jdbc/imagens/nicy.png"));
		lblNewLabel_2.setBounds(288, 155, 315, 171);
		panel.add(lblNewLabel_2);
		
		frame.setVisible(true);
		frame.setResizable(false);
		
		}

		public JFrame getFrame() {
			return frame;
		}

		public void setFrame(JFrame frame) {
			this.frame = frame;
		}

		public JButton getBtnNewButtonGerente() {
			return btnNewButtonGerente;
		}

		public void setBtnNewButtonGerente(JButton btnNewButtonGerente) {
			this.btnNewButtonGerente = btnNewButtonGerente;
		}

		public JButton getBtnNewButton_1Monitor() {
			return btnNewButton_1Monitor;
		}

		public void setBtnNewButton_1Monitor(JButton btnNewButton_1Monitor) {
			this.btnNewButton_1Monitor = btnNewButton_1Monitor;
		}

		public JButton getBtnNewButton_2jaPar() {
			return btnNewButton_2jaPar;
		}

		public void setBtnNewButton_2jaPar(JButton btnNewButton_2jaPar) {
			this.btnNewButton_2jaPar = btnNewButton_2jaPar;
		}

		public JButton getBtnNewButton_3par() {
			return btnNewButton_3par;
		}

		public void setBtnNewButton_3par(JButton btnNewButton_3par) {
			this.btnNewButton_3par = btnNewButton_3par;
		}
	

	
	}	
	
