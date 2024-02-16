package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class tela {
	private JTable tabela;
	private JScrollPane painel;
	private JPanel painelInserir = new JPanel();
	private JPanel painelAlterarRemover = new JPanel();
	
	private JLabel textotitulo = new JLabel("titulo");
	private JTextField campotitulo = new JTextField(255);
	
	private JLabel textoinserir = new JLabel("Inserir");
	private JButton btnInserir = new JButton("Inserir");

	public JButton getBtnInserir() {
		return btnInserir;
	}

	public void setBtnInserir(JButton btnInserir) {
		this.btnInserir = btnInserir;
	}
}
