package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.modelo;
import view.tela;

public class LivrosController {
	private tela view = new tela();
	
	ActionListener ouvinte = new ActionListener() {
		
		public void actionPerfomed(ActionEvent e) {
			if(e.getSource() == view.setBtnInserir()) {
				modelo livros = new modelo();
				livros.setTitulo(view.getBtnInserir().getText());
				
			}
		}
		
	};
}
