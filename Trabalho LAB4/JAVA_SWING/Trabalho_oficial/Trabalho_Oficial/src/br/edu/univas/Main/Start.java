package br.edu.univas.Main;

import java.sql.SQLException;

import br.edu.univas.Controller.MainController;

public class Start {
	public static void main(String[] args) throws SQLException {
		MainController controller = new MainController();
		controller.initApp();
	}
}

