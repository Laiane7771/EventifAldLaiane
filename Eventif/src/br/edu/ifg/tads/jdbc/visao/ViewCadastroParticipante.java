package br.edu.ifg.tads.jdbc.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewCadastroParticipante {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textField_RG;
	private JTextField textField_Cpf;
	private JTextField textField_CEP;
	private JTextField textField_Bairro;
	private JTextField textField_Cidade;
	private JTextField textField_Estado;
	private JTextField textField_Email;
	private JTextField textField_Telefone;
	private JTextField textField_matricula;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JLabel lblNewLabel_1;
	private JTextField textFieldSenha;
	private JTextField textField_numero;
	private JLabel lblN;

	public ViewCadastroParticipante() {

		frame = new JFrame("Cadastro Participante");
		frame.setBounds(100, 100, 937, 541);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(269, 117, 53, 15);
		panel.add(lblNome);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(291, 144, 24, 15);
		panel.add(lblRg);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(556, 144, 35, 15);
		panel.add(lblCpf);

		JLabel label = new JLabel("Informações Pessoais");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(157, 72, 232, 15);
		panel.add(label);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(322, 115, 453, 19);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);

		textField_RG = new JTextField();
		textField_RG.setBounds(321, 142, 171, 19);
		panel.add(textField_RG);
		textField_RG.setColumns(10);

		textField_Cpf = new JTextField();
		textField_Cpf.setBounds(592, 142, 183, 19);
		panel.add(textField_Cpf);
		textField_Cpf.setColumns(10);

		JLabel lblNewLabel = new JLabel("Endereço\n");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(157, 236, 146, 29);
		panel.add(lblNewLabel);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(479, 306, 35, 15);
		panel.add(lblCep);

		textField_CEP = new JTextField();
		textField_CEP.setBounds(516, 304, 143, 19);
		panel.add(textField_CEP);
		textField_CEP.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(269, 304, 58, 15);
		panel.add(lblBairro);

		textField_Bairro = new JTextField();
		textField_Bairro.setBounds(322, 302, 133, 19);
		panel.add(textField_Bairro);
		textField_Bairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(257, 332, 70, 15);
		panel.add(lblCidade);

		textField_Cidade = new JTextField();
		textField_Cidade.setBounds(322, 330, 133, 19);
		panel.add(textField_Cidade);
		textField_Cidade.setColumns(10);

		JLabel lblEndereço = new JLabel("Estado:");
		lblEndereço.setBounds(469, 332, 70, 15);
		panel.add(lblEndereço);

		textField_Estado = new JTextField();
		textField_Estado.setBounds(532, 330, 146, 19);
		panel.add(textField_Estado);
		textField_Estado.setColumns(10);

		textField_Email = new JTextField();
		textField_Email.setBounds(322, 173, 211, 19);
		panel.add(textField_Email);
		textField_Email.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(271, 175, 51, 15);
		panel.add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(540, 175, 70, 15);
		panel.add(lblTelefone);

		textField_Telefone = new JTextField();
		textField_Telefone.setBounds(612, 173, 163, 19);
		panel.add(textField_Telefone);
		textField_Telefone.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(658, 426, 117, 25);
		panel.add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(529, 426, 117, 25);
		panel.add(btnVoltar);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(244, 209, 95, 15);
		panel.add(lblMatricula);

		textField_matricula = new JTextField();
		textField_matricula.setBounds(322, 207, 146, 19);
		panel.add(textField_matricula);
		textField_matricula.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Senha:\n");
		lblNewLabel_1.setBounds(479, 209, 53, 15);
		panel.add(lblNewLabel_1);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(532, 207, 114, 19);
		panel.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		lblN = new JLabel("Nº:");
		lblN.setBounds(291, 277, 35, 15);
		panel.add(lblN);
		
		textField_numero = new JTextField();
		textField_numero.setBounds(322, 275, 114, 19);
		panel.add(textField_numero);
		textField_numero.setColumns(10);

		frame.setVisible(true);
		frame.setResizable(false);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JTextField getTextField_RG() {
		return textField_RG;
	}

	public void setTextField_RG(JTextField textField_RG) {
		this.textField_RG = textField_RG;
	}

	public JTextField getTextField_Cpf() {
		return textField_Cpf;
	}

	public void setTextField_Cpf(JTextField textField_Cpf) {
		this.textField_Cpf = textField_Cpf;
	}



	public JTextField getTextField_CEP() {
		return textField_CEP;
	}

	public void setTextField_CEP(JTextField textField_CEP) {
		this.textField_CEP = textField_CEP;
	}

	public JTextField getTextField_Bairro() {
		return textField_Bairro;
	}

	public void setTextField_Bairro(JTextField textField_Bairro) {
		this.textField_Bairro = textField_Bairro;
	}

	public JTextField getTextField_Cidade() {
		return textField_Cidade;
	}

	public void setTextField_Cidade(JTextField textField_Cidade) {
		this.textField_Cidade = textField_Cidade;
	}

	public JTextField getTextField_Estado() {
		return textField_Estado;
	}

	public void setTextField_Estado(JTextField textField_Estado) {
		this.textField_Estado = textField_Estado;
	}

	public JTextField getTextField_Email() {
		return textField_Email;
	}

	public void setTextField_Email(JTextField textField_Email) {
		this.textField_Email = textField_Email;
	}

	public JTextField getTextField_Telefone() {
		return textField_Telefone;
	}

	public void setTextField_Telefone(JTextField textField_Telefone) {
		this.textField_Telefone = textField_Telefone;
	}

	public JTextField getTextField_matricula() {
		return textField_matricula;
	}

	public void setTextField_matricula(JTextField textField_matricula) {
		this.textField_matricula = textField_matricula;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public void setTextFieldSenha(JTextField textFieldSenha) {
		this.textFieldSenha = textFieldSenha;
	}

	public JTextField getTextField_numero() {
		return textField_numero;
	}

	public void setTextField_numero(JTextField textField_numero) {
		this.textField_numero = textField_numero;
	}

	
}


