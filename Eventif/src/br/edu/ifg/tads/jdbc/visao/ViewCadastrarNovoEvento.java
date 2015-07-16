package br.edu.ifg.tads.jdbc.visao;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ViewCadastrarNovoEvento extends JInternalFrame{
	
		
		private JLabel lblNewLabel_1;
		private JLabel lblNewLabel_2;
		private JLabel lblDescrio;
		private JLabel lblNewLabel_3;
		private JLabel lblOrganizadora;
		private JLabel lblTelefonePContato;
		private JLabel lblEmailPContato;
		private JLabel lblNewLabel_4;
		private JLabel lblNewLabel_5;
		private JLabel lblN;
		private JTextField textField_LocaldoEv;
		private JTextField textField_Cidade;
		private JTextField textField_Bairro;
		private JTextField textField_Numero;
		private JTextField textFieldNome;
		private JTextField textField_Descricao;
		private JTextField textField_Telefone;
		private JTextField textField_Email;
		private JButton btnVoltar;
		private JButton btnSalvar;
		private JTextField textField_Organizador;
		private JTextField textField_cep;
		private JTextField textFieldEstado;
		private JTextField textFieldDataIni;
		private JTextField textField_DataEncerra;

		
		public ViewCadastrarNovoEvento() {
			setTitle("Cadastro Evento");
			getContentPane().setForeground(Color.WHITE);
			getContentPane().setBackground(Color.WHITE);
			getContentPane().setEnabled(false);
			setBounds(100, 100, 711, 444);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setSize(711,444);
			panel.setBounds(0, 0, 1, 434);
			panel.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.setForeground(Color.WHITE);
			panel.setBackground(Color.WHITE);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			textFieldNome = new JTextField();
			textFieldNome.setBounds(200, 51, 450, 19);
			getContentPane().add(textFieldNome);
			textFieldNome.setColumns(10);
			
			textField_Descricao = new JTextField();
			textField_Descricao.setBounds(200, 80, 450, 19);
			getContentPane().add(textField_Descricao);
			textField_Descricao.setColumns(10);
			
			textField_Telefone = new JTextField();
			textField_Telefone.setBounds(200, 140, 132, 19);
			getContentPane().add(textField_Telefone);
			textField_Telefone.setColumns(10);
			
			textField_Email = new JTextField();
			textField_Email.setBounds(428, 140, 222, 19);
			getContentPane().add(textField_Email);
			textField_Email.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Nome:");
			lblNewLabel.setBounds(148, 53, 70, 15);
			getContentPane().add(lblNewLabel);
			
			lblDescrio = new JLabel("Descrição:");
			lblDescrio.setBounds(124, 82, 80, 15);
			getContentPane().add(lblDescrio);
			
			lblOrganizadora = new JLabel("Organizador(a):");
			lblOrganizadora.setBounds(81, 113, 123, 15);
			getContentPane().add(lblOrganizadora);
			
			lblTelefonePContato = new JLabel("Telefone P/ Contato:");
			lblTelefonePContato.setBounds(53, 141, 151, 15);
			getContentPane().add(lblTelefonePContato);
			
			lblEmailPContato = new JLabel("Email:");
			lblEmailPContato.setBounds(379, 141, 45, 17);
			getContentPane().add(lblEmailPContato);
			
			lblNewLabel_1 = new JLabel("Local do Evento:");
			lblNewLabel_1.setBounds(81, 173, 119, 15);
			getContentPane().add(lblNewLabel_1);
			
			lblNewLabel_2 = new JLabel("Informações");
			lblNewLabel_2.setFont(new Font("URW Chancery L", Font.BOLD, 20));
			lblNewLabel_2.setForeground(Color.BLACK);
			lblNewLabel_2.setBounds(12, 0, 151, 25);
			getContentPane().add(lblNewLabel_2);
			
			textField_LocaldoEv = new JTextField();
			textField_LocaldoEv.setBounds(200, 171, 450, 19);
			getContentPane().add(textField_LocaldoEv);
			textField_LocaldoEv.setColumns(10);
			
			lblNewLabel_3 = new JLabel("Endereço");
			lblNewLabel_3.setFont(new Font("URW Chancery L", Font.BOLD, 20));
			lblNewLabel_3.setBounds(12, 229, 91, 25);
			getContentPane().add(lblNewLabel_3);
			
			textField_Cidade = new JTextField();
			textField_Cidade.setBounds(200, 313, 114, 19);
			getContentPane().add(textField_Cidade);
			textField_Cidade.setColumns(10);
			
			textField_Bairro = new JTextField();
			textField_Bairro.setBounds(200, 288, 297, 19);
			getContentPane().add(textField_Bairro);
			textField_Bairro.setColumns(10);
			
			textField_Numero = new JTextField();
			textField_Numero.setBounds(527, 288, 123, 19);
			getContentPane().add(textField_Numero);
			textField_Numero.setColumns(10);
			
			lblNewLabel_4 = new JLabel("Cidade:");
			lblNewLabel_4.setBounds(146, 315, 54, 15);
			getContentPane().add(lblNewLabel_4);
			
			lblNewLabel_5 = new JLabel("Bairro:");
			lblNewLabel_5.setBounds(148, 290, 70, 15);
			getContentPane().add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Estado:");
			lblNewLabel_6.setBounds(320, 315, 64, 15);
			getContentPane().add(lblNewLabel_6);
			
			lblN = new JLabel("Nº:");
			lblN.setBounds(503, 290, 32, 15);
			getContentPane().add(lblN);
			

			btnSalvar = new JButton("Salvar");
			btnSalvar.setBounds(533, 375, 117, 25);
			getContentPane().add(btnSalvar);
			
			textField_Organizador = new JTextField();
			textField_Organizador.setBounds(200, 111, 450, 19);
			getContentPane().add(textField_Organizador);
			textField_Organizador.setColumns(10);
			
			JLabel lblCep = new JLabel("CEP:");
			lblCep.setBounds(164, 342, 40, 19);
			getContentPane().add(lblCep);
			
			textField_cep = new JTextField();
			textField_cep.setBounds(200, 342, 132, 19);
			getContentPane().add(textField_cep);
			textField_cep.setColumns(10);
			
			textFieldEstado = new JTextField();
			textFieldEstado.setBounds(379, 313, 114, 19);
			getContentPane().add(textFieldEstado);
			textFieldEstado.setColumns(10);
			
			JLabel lblDataDeInicio = new JLabel("Data de Início:");
			lblDataDeInicio.setBounds(91, 200, 106, 15);
			getContentPane().add(lblDataDeInicio);
			
			textFieldDataIni = new JTextField();
			textFieldDataIni.setBounds(200, 198, 147, 19);
			getContentPane().add(textFieldDataIni);
			textFieldDataIni.setColumns(10);
			
			JLabel lblDataDeEncerramento = new JLabel("Data de Encerramento:");
			lblDataDeEncerramento.setBounds(353, 200, 164, 15);
			getContentPane().add(lblDataDeEncerramento);
			
			textField_DataEncerra = new JTextField();
			textField_DataEncerra.setBounds(517, 198, 133, 19);
			getContentPane().add(textField_DataEncerra);
			textField_DataEncerra.setColumns(10);
			
			this.setClosable(true);
			this.setVisible(true);

		}


		public JLabel getLblNewLabel_1() {
			return lblNewLabel_1;
		}


		public void setLblNewLabel_1(JLabel lblNewLabel_1) {
			this.lblNewLabel_1 = lblNewLabel_1;
		}


		public JLabel getLblNewLabel_2() {
			return lblNewLabel_2;
		}


		public void setLblNewLabel_2(JLabel lblNewLabel_2) {
			this.lblNewLabel_2 = lblNewLabel_2;
		}


		public JLabel getLblDescrio() {
			return lblDescrio;
		}


		public void setLblDescrio(JLabel lblDescrio) {
			this.lblDescrio = lblDescrio;
		}


		public JLabel getLblNewLabel_3() {
			return lblNewLabel_3;
		}


		public void setLblNewLabel_3(JLabel lblNewLabel_3) {
			this.lblNewLabel_3 = lblNewLabel_3;
		}


		public JLabel getLblOrganizadora() {
			return lblOrganizadora;
		}


		public void setLblOrganizadora(JLabel lblOrganizadora) {
			this.lblOrganizadora = lblOrganizadora;
		}


		public JLabel getLblTelefonePContato() {
			return lblTelefonePContato;
		}


		public void setLblTelefonePContato(JLabel lblTelefonePContato) {
			this.lblTelefonePContato = lblTelefonePContato;
		}


		public JLabel getLblEmailPContato() {
			return lblEmailPContato;
		}


		public void setLblEmailPContato(JLabel lblEmailPContato) {
			this.lblEmailPContato = lblEmailPContato;
		}


		public JLabel getLblNewLabel_4() {
			return lblNewLabel_4;
		}


		public void setLblNewLabel_4(JLabel lblNewLabel_4) {
			this.lblNewLabel_4 = lblNewLabel_4;
		}


		public JLabel getLblNewLabel_5() {
			return lblNewLabel_5;
		}


		public void setLblNewLabel_5(JLabel lblNewLabel_5) {
			this.lblNewLabel_5 = lblNewLabel_5;
		}


		public JLabel getLblN() {
			return lblN;
		}


		public void setLblN(JLabel lblN) {
			this.lblN = lblN;
		}


		public JTextField getTextField_LocaldoEv() {
			return textField_LocaldoEv;
		}


		public void setTextField_LocaldoEv(JTextField textField_LocaldoEv) {
			this.textField_LocaldoEv = textField_LocaldoEv;
		}


		public JTextField getTextField_Cidade() {
			return textField_Cidade;
		}


		public void setTextField_Cidade(JTextField textField_Cidade) {
			this.textField_Cidade = textField_Cidade;
		}


		public JTextField getTextField_Bairro() {
			return textField_Bairro;
		}


		public void setTextField_Bairro(JTextField textField_Bairro) {
			this.textField_Bairro = textField_Bairro;
		}


		public JTextField getTextField_Numero() {
			return textField_Numero;
		}


		public void setTextField_Numero(JTextField textField_Numero) {
			this.textField_Numero = textField_Numero;
		}


		public JTextField getTextFieldEstado() {
			return textFieldEstado;
		}


		public void setTextFieldEstado(JTextField textFieldEstado) {
			this.textFieldEstado = textFieldEstado;
		}


		public JTextField getTextFieldNome() {
			return textFieldNome;
		}


		public void setTextFieldNome(JTextField textFieldNome) {
			this.textFieldNome = textFieldNome;
		}


		public JTextField getTextField_Descricao() {
			return textField_Descricao;
		}


		public void setTextField_Descricao(JTextField textField_Descricao) {
			this.textField_Descricao = textField_Descricao;
		}


		public JTextField getTextField_Telefone() {
			return textField_Telefone;
		}


		public void setTextField_Telefone(JTextField textField_Telefone) {
			this.textField_Telefone = textField_Telefone;
		}


		public JTextField getTextField_Email() {
			return textField_Email;
		}


		public void setTextField_Email(JTextField textField_Email) {
			this.textField_Email = textField_Email;
		}


		public JButton getBtnVoltar() {
			return btnVoltar;
		}


		public void setBtnVoltar(JButton btnVoltar) {
			this.btnVoltar = btnVoltar;
		}


		public JButton getBtnSalvar() {
			return btnSalvar;
		}


		public void setBtnSalvar(JButton btnSalvar) {
			this.btnSalvar = btnSalvar;
		}


		public JTextField getTextField_Organizador() {
			return textField_Organizador;
		}


		public void setTextField_Organizador(JTextField textField_Organizador) {
			this.textField_Organizador = textField_Organizador;
		}


		public JTextField getTextField_cep() {
			return textField_cep;
		}


		public void setTextField_cep(JTextField textField_cep) {
			this.textField_cep = textField_cep;
		}


		public JTextField getTextFieldDataIni() {
			return textFieldDataIni;
		}


		public void setTextFieldDataIni(JTextField textFieldDataIni) {
			this.textFieldDataIni = textFieldDataIni;
		}


		public JTextField getTextField_DataEncerra() {
			return textField_DataEncerra;
		}


		public void setTextField_DataEncerra(JTextField textField_DataEncerra) {
			this.textField_DataEncerra = textField_DataEncerra;
		}
		
}



