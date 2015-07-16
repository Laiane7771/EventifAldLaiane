package br.edu.ifg.tads.jdbc.main;



import br.edu.ifg.tads.jdbc.controlador.ControleTelaInicial;
import br.edu.ifg.tads.jdbc.visao.ViewTelaInicial;

public class Main {

	public static void main(String[] args) {
		
		ViewTelaInicial tl = new ViewTelaInicial();
		ControleTelaInicial ti = new ControleTelaInicial(tl);
		tl.getFrame().setVisible(true);
	
		
	
		
	}
}
