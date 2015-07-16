package br.edu.ifg.tads.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.edu.ifg.tads.jdbc.dao.AtividadeDao;
import br.edu.ifg.tads.jdbc.modelo.Atividade;
import br.edu.ifg.tads.jdbc.visao.ViewAlteraAtividade;
import br.edu.ifg.tads.jdbc.visao.ViewCadastroNovaAtividade;
import br.edu.ifg.tads.jdbc.visao.ViewListaAtividades;


public class ControleListaAtividades {

	private ViewListaAtividades vla;
	private Atividade a;
	private ViewCadastroNovaAtividade vcna;
	private AtividadeDao adao = new AtividadeDao();
	private int idLinha;
	private int idEvento;

	public ControleListaAtividades(ViewListaAtividades vla, Atividade a, int idEvento){
		this.idEvento = idEvento;
		this.vla = vla;
		this.a = a;
		adicionaEventos();
		preencheTabela(adao.buscaAtividades(idEvento));
	}

	public void adicionaEventos(){

		vla.getBtnNewButtonPesquisar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Atividade a = new Atividade();
				a.setNomeAtividade(vla.getTextField().getText());
				Vector<Vector<String>> listaAtividades = adao.buscaAtividadeNome(a);
				preencheTabela(listaAtividades);

			}
		});

		vla.getBtnAlterar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = vla.getTable_ListaAtividades().getSelectedRow();
				int id = Integer.parseInt(vla.getTable_ListaAtividades().getValueAt(index, 0).toString());
				Atividade at = new Atividade();
				at.setIdAtividade(id);
				Atividade bc = adao.buscaAtividade(at);
				ViewAlteraAtividade vaa = new ViewAlteraAtividade();
				new ControleAlteraAtividade(vaa,bc,adao);
				vla.add(vaa);

			}
		});

		vla.getBtnNewButtonExcluir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = vla.getTable_ListaAtividades().getSelectedRow();
				int id = Integer.parseInt(vla.getTable_ListaAtividades().getValueAt(index, 0).toString());
				Atividade at = new Atividade();
				at.setIdAtividade(id);
				Atividade bc = adao.buscaAtividade(at);
				int r = JOptionPane.showConfirmDialog( vcna, "Realmente deseja excluir o contato " + bc.getNomeAtividade() + "?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION );
				if(r==0){
					adao.removeAtividade(bc);
					preencheTabela(adao.buscaAtividades(idEvento));

				}
			}

		});
		vla.getBtnNovaAtividade().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				instanciaClasse();



			}
		});
		vla.getTable_ListaAtividades().addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = ((JTable)arg0.getSource()).getSelectedRow();
				idLinha = Integer.parseInt(vla.getTable_ListaAtividades().getValueAt(linha, 0).toString());
				vla.getBtnAlterar().setEnabled(true);
				vla.getBtnNewButtonExcluir().setEnabled(true);

			}
		});

	}


	public void preencheTabela(Vector<Vector<String>> listaAtividades){
		vla.getTable_ListaAtividades().clearSelection();
		vla.getTable_ListaAtividades().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Evento");
		colunas.add("Atividade");
		colunas.add("Vagas");

		DefaultTableModel model = new DefaultTableModel(listaAtividades, colunas);
		vla.getTable_ListaAtividades().setModel(model);
		vla.getTable_ListaAtividades().getColumn("id").setMaxWidth(25);
	}
	public void preencheTabela(){

		preencheTabela(adao.buscaAtividades(idLinha));
	}
	public void instanciaClasse(){

		ViewCadastroNovaAtividade vcna = new ViewCadastroNovaAtividade();
		Atividade a = new Atividade();
		a.getEvento().setIdEvento(idLinha);
		ControleCadastroNovaAtividade ccna = new ControleCadastroNovaAtividade(vcna, a, idLinha);
	}


}
