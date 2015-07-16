package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.visao.ViewAlteraParticipante;

public class ControleAlteraParticipante {

	private ViewAlteraParticipante vap;
	private Participante p;
	private ParticipanteDao pdao;

	public ControleAlteraParticipante(ViewAlteraParticipante vap,Participante p, ParticipanteDao pdao){
		this.vap = vap;
		this.p = p;
		this.pdao = pdao;
		adicionaEventos();
		carregaDadosAlteraParticipante();

	}
	public void carregaDadosAlteraParticipante(){
		
		ParticipanteDao pDao = new ParticipanteDao();
		p = pDao.buscaparticipante(p);
		
		vap.getTextFieldNome().setText(p.getPessoa().getNomePessoa());
		vap.getTextField_Cpf().setText(p.getPessoa().getCpf());
		vap.getTextField_RG().setText(p.getPessoa().getRg());
		vap.getTextFieldSenha().setText(p.getPessoa().getSenha());
		vap.getTextField_Email().setText(p.getPessoa().getContatopessoa().getEmail());
		vap.getTextField_Telefone().setText(p.getPessoa().getContatopessoa().getTelefonePessoa());
		vap.getTextField_numero().setText(p.getPessoa().getEnderecopessoa().getNumero());
		vap.getTextField_Bairro().setText(p.getPessoa().getEnderecopessoa().getBairro());
		vap.getTextField_CEP().setText(p.getPessoa().getEnderecopessoa().getCep());
		vap.getTextField_Cidade().setText(p.getPessoa().getEnderecopessoa().getCidade().getNomeCidade());
		vap.getTextField_Estado().setText(p.getPessoa().getEnderecopessoa().getCidade().getEstado().getNomeEstado());

	}

	public void adicionaEventos(){
		
		vap.getBtnCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				vap.getFrame().dispose();


			}
		});
		vap.getBtnAlterar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Participante pt  = new Participante();

				pt.getPessoa().setNomePessoa(vap.getTextFieldNome().getText());
				pt.getPessoa().setCpf(vap.getTextField_Cpf().getText());
				pt.getPessoa().setRg(vap.getTextField_RG().getText());
				pt.getPessoa().setSenha(vap.getTextFieldSenha().getText());
				pt.setMatricula(vap.getTextField_matricula().getText());
				pt.getPessoa().getContatopessoa().setEmail(vap.getTextField_Email().getText());
				pt.getPessoa().getContatopessoa().setTelefonePessoa(vap.getTextField_Telefone().getText());
				pt.getPessoa().getEnderecopessoa().setBairro(vap.getTextField_Bairro().getText());
				pt.getPessoa().getEnderecopessoa().setCep(vap.getTextField_CEP().getText());
				pt.getPessoa().getEnderecopessoa().setNumero(vap.getTextField_numero().getText());
				pt.getPessoa().getEnderecopessoa().getCidade().setNomeCidade(vap.getTextField_Cidade().getText());
				pt.getPessoa().getEnderecopessoa().getCidade().getEstado().setNomeEstado(vap.getTextField_Estado().getText());

				try{
					pdao.alteraParticipante(pt);
					pdao.alteraPessoa(pt.getPessoa());
					pdao.alteraContatoPessoa(pt.getPessoa().getContatopessoa());
					pdao.alteraEnderecoPessoa(pt.getPessoa().getEnderecopessoa());
				}catch(Exception ex){
					System.out.println(ex);
				}

				//Dispatcher.getInstance().dispatchEvent(new Event("alteracao"));


				vap.getFrame().dispose();

			}
		});	
		
	}

}
