package view;

import static javax.swing.JOptionPane.showOptionDialog;

public class Menu {
	public static void main(final String args[]) {

		final int i = showOptionDialog(null, "Escolha uma opção", "Divulga Tudo", 0, 3, null,
				new String[] { "Cadastrar anuncio", "Relatorio", "Sair" }, "Incluir");

		switch (i) {
		case -1:
			System.exit(0);
		case 0:
			CadastroGUI.GUI(null);
			break;
		case 1:
			RelatorioGUI.GUI(null);
			break;
		case 2:
			System.exit(0);
		}
	}
}
