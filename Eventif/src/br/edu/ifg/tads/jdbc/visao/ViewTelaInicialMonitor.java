package br.edu.ifg.tads.jdbc.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewTelaInicialMonitor {

	private JFrame frame;
	private JButton btnQRcode;
	private JButton btnNewButton_CPF;
	private JButton btnLogout;
	private JDesktopPane jdp;
	
	public ViewTelaInicialMonitor() {
		
		jdp = new JDesktopPane();
		jdp.setLayout(null); 
		frame = new JFrame("Ambiente Monitor");
		frame.setContentPane(jdp);
		frame.setBounds(100, 100, 937, 541);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setSize(937,541);
	//	jdp.add(panel, BorderLayout.CENTER);
		panel.setBounds(45, 31, 853, 461);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		JLabel lblAmbienteMonitor = new JLabel("Ambiente Monitor");
		lblAmbienteMonitor.setFont(new Font("URW Chancery L", Font.BOLD, 30));
		lblAmbienteMonitor.setBounds(318, 12, 293, 37);
		panel.add(lblAmbienteMonitor);
		
		btnQRcode = new JButton("QRCODE");
		btnQRcode.setFont(new Font("URW Chancery L", Font.BOLD, 14));
		btnQRcode.setBounds(83, 141, 228, 77);
		panel.add(btnQRcode);
		
		btnNewButton_CPF = new JButton("CPF");
		btnNewButton_CPF.setFont(new Font("URW Chancery L", Font.BOLD, 16));
		btnNewButton_CPF.setBounds(84, 252, 227, 84);
		panel.add(btnNewButton_CPF);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("/home/laiane/workspace/Eventif/src/br/edu/ifg/tads/jdbc/imagens/nicy.png"));
		label.setBounds(398, 141, 320, 155);
		panel.add(label);
		
		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("URW Chancery L", Font.BOLD, 16));
		btnLogout.setBounds(227, 369, 84, 45);
		panel.add(btnLogout);
		
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnQRcode() {
		return btnQRcode;
	}

	public void setBtnQRcode(JButton btnQRcode) {
		this.btnQRcode = btnQRcode;
	}

	public JButton getBtnNewButton_CPF() {
		return btnNewButton_CPF;
	}

	public void setBtnNewButton_CPF(JButton btnNewButton_CPF) {
		this.btnNewButton_CPF = btnNewButton_CPF;
	}

	public JDesktopPane getJdp() {
		return jdp;
	}

	public void setJdp(JDesktopPane jdp) {
		this.jdp = jdp;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}
	
}
