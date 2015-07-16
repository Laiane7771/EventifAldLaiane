package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;
import br.edu.ifg.tads.jdbc.modelo.Gerente;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Pessoa;
import br.edu.ifg.tads.jdbc.visao.ViewCadastroParticipante;



public class ControleCadastroParticipante {

	private ViewCadastroParticipante vCP;
	private Participante par;
	private ParticipanteDao pd;


	public ControleCadastroParticipante(ViewCadastroParticipante vCP, Participante par, ParticipanteDao pd){

		this.vCP = vCP;
		this.par = par;
		this.pd = pd;
		adicionaEvento();

	}

	public void adicionaEvento(){

		vCP.getBtnSalvar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				inscricao();
			

			}
		});

		vCP.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				vCP.getFrame().dispose();

			}
		});

	}

	public void inscricao(){
		Participante p = new Participante();
		p.getPessoa().setNomePessoa(vCP.getTextFieldNome().getText());
		p.getPessoa().setRg((vCP.getTextField_RG().getText()));
		p.getPessoa().setCpf(vCP.getTextField_Cpf().getText());
		p.getPessoa().getContatopessoa().setEmail(vCP.getTextField_Email().getText());
		p.getPessoa().getContatopessoa().setTelefonePessoa(vCP.getTextField_Telefone().getText());
		p.setMatricula(vCP.getTextField_matricula().getText());
		p.getPessoa().setSenha(vCP.getTextFieldSenha().getText());
		p.getPessoa().getEnderecopessoa().setNumero(vCP.getTextField_numero().getText());
		p.getPessoa().getEnderecopessoa().setCep(vCP.getTextField_CEP().getText());
		p.getPessoa().getEnderecopessoa().setBairro(vCP.getTextField_Bairro().getText());
		p.getPessoa().getEnderecopessoa().getCidade().setNomeCidade(vCP.getTextField_Cidade().getText());
		p.getPessoa().getEnderecopessoa().getCidade().getEstado().setNomeEstado(vCP.getTextField_Estado().getText());

		if(vCP.getTextFieldNome().getText().isEmpty()||vCP.getTextField_RG().getText().isEmpty()||vCP.getTextField_Cpf().getText().isEmpty()||vCP.getTextFieldSenha().getText().isEmpty()
				||vCP.getTextField_Email().getText().isEmpty()||vCP.getTextField_Telefone().getText().isEmpty()||vCP.getTextField_matricula().getText().isEmpty()
				||vCP.getTextField_numero().getText().isEmpty()||vCP.getTextField_CEP().getText().isEmpty()||vCP.getTextField_Bairro().getText().isEmpty()
				||vCP.getTextField_Cidade().getText().isEmpty()||vCP.getTextField_Estado().getText().isEmpty()){

			JOptionPane.showMessageDialog(null, "Por favor, preencha os campos vazios!");

		}
		else{

			ParticipanteDao pd = new ParticipanteDao();
			pd.inserir(p);
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com Sucesso!");
			JOptionPane.showMessageDialog(null, "Anote seu Login e Senha:\n"+
					"Login: "+ p.getPessoa().getCpf()+ "\n"+
					"Senha: "+ p.getPessoa().getSenha());
			
			vCP.getFrame().dispose();
		}
	}}
