package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.*;

public class RelatorioGUI {
	private JFrame frmRelatorio;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Timestamp Inicio;
	private Timestamp Termino;

	/**
	 * Abre a aplicacao.
	 */
	public static void GUI(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioGUI window = new RelatorioGUI();
					window.frmRelatorio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicializa a aplicacao.
	 */
	public RelatorioGUI() {
		initialize();
	}

	/**
	 * Inicializa conteudo do frame.
	 */
	void initialize() {
		frmRelatorio = new JFrame();
		frmRelatorio.setTitle("Cadastro de Anuncios");
		frmRelatorio.setBounds(100, 100, 633, 200);
		//
		frmRelatorio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRelatorio.getContentPane().setLayout(null);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(50, 100, 90, 23);
		frmRelatorio.getContentPane().add(btnListar);

		JButton btnListarporData = new JButton("Listar por data");
		btnListarporData.setBounds(150, 100, 150, 23);
		frmRelatorio.getContentPane().add(btnListarporData);

		JButton btnListarPorCliente = new JButton("Listar por cliente");
		btnListarPorCliente.setBounds(310, 100, 150, 23);
		frmRelatorio.getContentPane().add(btnListarPorCliente);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(500, 100, 89, 23);

		frmRelatorio.getContentPane().add(btnVoltar);

		/**
		 * Insere funcao nos botoes
		 */

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dao.RelatorioDao anuncio = new dao.RelatorioDao();
				anuncio.listaAnuncios();
			}
		});

		btnListarporData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Timestamp inicial = Timestamp
						.valueOf(JOptionPane.showInputDialog("Digite a data inicial (yyyy-MM-dd hh:mm:ss)"));
				Timestamp fin = Timestamp
						.valueOf(JOptionPane.showInputDialog("Digite a data final (yyyy-MM-dd hh:mm:ss)"));
				dao.RelatorioDao anuncios = new dao.RelatorioDao();
				anuncios.listdataAnuncios(inicial, fin);
			}
		});

		btnListarPorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Cliente = JOptionPane.showInputDialog("Digite o nome do cliente que deseja filtrar");
				dao.RelatorioDao anuncios = new dao.RelatorioDao();
				anuncios.listClienteAnuncios(Cliente);
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRelatorio.dispose();
				Menu.main(null);

			}
		});

	}
}
