package br.edu.ifg.tads.jdbc.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewAlteraAtividade extends JDialog {
	private JTextField textFieldNome;
	private JTextField textField_Descricao;
	private JTextField textField_TipoAtivi;
	private JTextField textField_Ministrante;
	private JTextField textField_Data;
	private JTextField textFieldHoraInicio;
	private JTextField textField_HoraEncerra;
	private JLabel lblNome;
	private JLabel lblDescrio;
	private JLabel lblTipoDaAtividade;
	private JLabel lblMinistrante;
	private JLabel lblData;
	private JLabel lblHoraIncio;
	private JLabel lblHoraEncerramento;
	private JLabel lblNDeVagas;
	private JTextField textField_NumeroVagas;
	private JButton btnAlterar;
	private JButton btnCancelar;

	public ViewAlteraAtividade() {
		setBounds(100, 100, 735, 466);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCadastroDeAtividades = new JLabel("Cadastro de Atividades ");
		lblCadastroDeAtividades.setFont(new Font("URW Chancery L", Font.BOLD, 20));
		lblCadastroDeAtividades.setBounds(262, 40, 220, 25);
		panel.add(lblCadastroDeAtividades);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(147, 126, 467, 19);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textField_Descricao = new JTextField();
		textField_Descricao.setBounds(147, 157, 467, 19);
		panel.add(textField_Descricao);
		textField_Descricao.setColumns(10);
		
		textField_TipoAtivi = new JTextField();
		textField_TipoAtivi.setBounds(147, 188, 149, 19);
		panel.add(textField_TipoAtivi);
		textField_TipoAtivi.setColumns(10);
		
		textField_Ministrante = new JTextField();
		textField_Ministrante.setBounds(402, 188, 212, 19);
		panel.add(textField_Ministrante);
		textField_Ministrante.setColumns(10);
		
		textField_Data = new JTextField();
		textField_Data.setBounds(147, 219, 95, 19);
		panel.add(textField_Data);
		textField_Data.setColumns(10);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setBounds(147, 250, 95, 19);
		panel.add(textFieldHoraInicio);
		textFieldHoraInicio.setColumns(10);
		
		textField_HoraEncerra = new JTextField();
		textField_HoraEncerra.setBounds(390, 250, 114, 19);
		panel.add(textField_HoraEncerra);
		textField_HoraEncerra.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(95, 128, 54, 15);
		panel.add(lblNome);
		
		lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(65, 159, 84, 15);
		panel.add(lblDescrio);
		
		lblTipoDaAtividade = new JLabel("Tipo da Atividade:");
		lblTipoDaAtividade.setBounds(15, 190, 128, 15);
		panel.add(lblTipoDaAtividade);
		
		lblMinistrante = new JLabel("Ministrante:");
		lblMinistrante.setBounds(305, 190, 96, 15);
		panel.add(lblMinistrante);
		
		lblData = new JLabel("Data:");
		lblData.setBounds(101, 219, 48, 15);
		panel.add(lblData);
		
		lblHoraIncio = new JLabel("Hora Início:");
		lblHoraIncio.setBounds(59, 248, 84, 15);
		panel.add(lblHoraIncio);
		
		lblHoraEncerramento = new JLabel("Hora Encerramento:");
		lblHoraEncerramento.setBounds(246, 252, 142, 15);
		panel.add(lblHoraEncerramento);
		
		lblNDeVagas = new JLabel("Nº de Vagas:");
		lblNDeVagas.setBounds(246, 221, 101, 15);
		panel.add(lblNDeVagas);
		
		textField_NumeroVagas = new JTextField();
		textField_NumeroVagas.setBounds(344, 219, 114, 19);
		panel.add(textField_NumeroVagas);
		textField_NumeroVagas.setColumns(10);
		
		btnAlterar = new JButton("alterar");
		btnAlterar.setFont(new Font("URW Chancery L", Font.BOLD, 20));
		btnAlterar.setBounds(489, 341, 96, 25);
		panel.add(btnAlterar);
		
	    btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCancelar.setBounds(357, 340, 101, 28);
		panel.add(btnCancelar);
		
		this.setVisible(true);
		this.setModal(true);
	

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

	public JTextField getTextField_TipoAtivi() {
		return textField_TipoAtivi;
	}

	public void setTextField_TipoAtivi(JTextField textField_TipoAtivi) {
		this.textField_TipoAtivi = textField_TipoAtivi;
	}

	public JTextField getTextField_Ministrante() {
		return textField_Ministrante;
	}

	public void setTextField_Ministrante(JTextField textField_Ministrante) {
		this.textField_Ministrante = textField_Ministrante;
	}

	public JTextField getTextField_Data() {
		return textField_Data;
	}

	public void setTextField_Data(JTextField textField_Data) {
		this.textField_Data = textField_Data;
	}

	public JTextField getTextFieldHoraInicio() {
		return textFieldHoraInicio;
	}

	public void setTextFieldHoraInicio(JTextField textFieldHoraInicio) {
		this.textFieldHoraInicio = textFieldHoraInicio;
	}

	public JTextField getTextField_HoraEncerra() {
		return textField_HoraEncerra;
	}

	public void setTextField_HoraEncerra(JTextField textField_HoraEncerra) {
		this.textField_HoraEncerra = textField_HoraEncerra;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblDescrio() {
		return lblDescrio;
	}

	public void setLblDescrio(JLabel lblDescrio) {
		this.lblDescrio = lblDescrio;
	}

	public JLabel getLblTipoDaAtividade() {
		return lblTipoDaAtividade;
	}

	public void setLblTipoDaAtividade(JLabel lblTipoDaAtividade) {
		this.lblTipoDaAtividade = lblTipoDaAtividade;
	}

	public JLabel getLblMinistrante() {
		return lblMinistrante;
	}

	public void setLblMinistrante(JLabel lblMinistrante) {
		this.lblMinistrante = lblMinistrante;
	}

	public JLabel getLblData() {
		return lblData;
	}

	public void setLblData(JLabel lblData) {
		this.lblData = lblData;
	}

	public JLabel getLblHoraIncio() {
		return lblHoraIncio;
	}

	public void setLblHoraIncio(JLabel lblHoraIncio) {
		this.lblHoraIncio = lblHoraIncio;
	}

	public JLabel getLblHoraEncerramento() {
		return lblHoraEncerramento;
	}

	public void setLblHoraEncerramento(JLabel lblHoraEncerramento) {
		this.lblHoraEncerramento = lblHoraEncerramento;
	}

	public JLabel getLblNDeVagas() {
		return lblNDeVagas;
	}

	public void setLblNDeVagas(JLabel lblNDeVagas) {
		this.lblNDeVagas = lblNDeVagas;
	}

	public JTextField getTextField_NumeroVagas() {
		return textField_NumeroVagas;
	}

	public void setTextField_NumeroVagas(JTextField textField_NumeroVagas) {
		this.textField_NumeroVagas = textField_NumeroVagas;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	public void setBtnAlterar(JButton btnAlterar) {
		this.btnAlterar = btnAlterar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	
}
