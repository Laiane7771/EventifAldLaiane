package br.edu.ifg.tads.jdbc.controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.edu.ifg.tads.jdbc.dao.EventoDao;
import br.edu.ifg.tads.jdbc.dao.ParticipanteDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.modelo.Evento;
import br.edu.ifg.tads.jdbc.modelo.Participante;
import br.edu.ifg.tads.jdbc.visao.ViewAlteraParticipante;
import br.edu.ifg.tads.jdbc.visao.ViewCadastroParticipante;
import br.edu.ifg.tads.jdbc.visao.ViewExibeAtividades;
import br.edu.ifg.tads.jdbc.visao.ViewInscreverEmAtividade;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicialParticipante;

public class ControleTelaInicialParticipante {

	private ViewTelaInicialParticipante vipe;
	private ParticipanteDao pd = new ParticipanteDao();
	private EventoDao ed = new EventoDao();
	private Participante p = new Participante();
	private int idLinha;
	private ViewCadastroParticipante vcp;

	ControleTelaInicialParticipante(ViewTelaInicialParticipante vipe, Participante p, int idLinha){
		this.vipe = vipe;
		this.p = p;
		this.idLinha = idLinha;
		adicionaEventos();
		preencheTabela(ed.buscaEventos(idLinha));
	}

	public void adicionaEventos(){
		vipe.getBtnPesquisar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Evento e = new Evento();
				e.setNomeEvento(vipe.getTextField_pesquisar().getText());
				Vector<Vector<String>> listaEventos = ed.buscaEventoNome(e);
				preencheTabela(listaEventos);
			}
		});

		vipe.getBtnAcessar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Inscrever();

			}
		});
		vipe.getBtnLogout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				vipe.getFrame().dispose();

			}
		});

		vipe.getBtnVerAtividadesEscolhidas().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ViewExibeAtividades veA = new ViewExibeAtividades();
				ControleExibeAtividades cea = new ControleExibeAtividades(veA, p.getIdParticipante());
				vipe.getJdp().add(veA);
				vipe.getJdp().moveToFront(veA);
			}
		});

		vipe.getTableParticipante_evento().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(vipe.getTableParticipante_evento().getValueAt(linha, 0).toString());
				vipe.getBtnAcessar().setEnabled(true);


			}});
		vipe.getBtnAlterarDados().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*
			  	p.setIdParticipante(idLinha);

				int id = p.getIdParticipante();
				 */
			
				ViewAlteraParticipante vap = new ViewAlteraParticipante();
				new ControleAlteraParticipante(vap,p,pd);


			}
		});

	}
	
	public Participante buscaID(){
		Participante pl = new Participante();
		try{
			p = pd.buscaParticipanteporID(pl);
		}catch(Exception ex){
			System.out.println(ex);
			
		} 
		return p;
	}
	


	public void preencheTabela(Vector<Vector<String>> listaEventos){
		vipe.getTableParticipante_evento().clearSelection();
		vipe.getTableParticipante_evento().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Nome");
		colunas.add("Organizador(a)");
		colunas.add("Descrição");

		DefaultTableModel model = new DefaultTableModel(listaEventos, colunas);
		vipe.getTableParticipante_evento().setModel(model);
		vipe.getTableParticipante_evento().getColumn("id").setMaxWidth(25);

	}

	public void Inscrever(){
		Atividade a = new Atividade();
		ViewInscreverEmAtividade viea = new ViewInscreverEmAtividade();
		ControleInscreverEmAtividade ciea = new ControleInscreverEmAtividade(viea, p, idLinha);
		vipe.getJdp().add(viea);
		vipe.getJdp().moveToFront(viea);
	}

}