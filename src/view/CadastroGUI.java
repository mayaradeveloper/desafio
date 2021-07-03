package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.*;

public class CadastroGUI {
	private JFrame frmCadastro;
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
					CadastroGUI window = new CadastroGUI();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicializa a aplicacao.
	 */
	public CadastroGUI() {
		initialize();
	}

	/**
	 * Inicializa o conteudo do frame.
	 */
	void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro de Anuncios");
		frmCadastro.setBounds(100, 100, 633, 371);
		//
		frmCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome do anuncio");
		lblNewLabel.setBounds(150, 54, 100, 14);
		frmCadastro.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setBounds(150, 77, 82, 14);
		frmCadastro.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data de inicio");
		lblNewLabel_2.setBounds(150, 102, 108, 14);
		frmCadastro.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Data de termino");
		lblNewLabel_3.setBounds(150, 127, 108, 14);
		frmCadastro.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Investimento por dia");
		lblNewLabel_4.setBounds(150, 152, 46, 14);
		frmCadastro.getContentPane().add(lblNewLabel_4);

		textField_1 = new JTextField();
		textField_1.setBounds(260, 51, 156, 20);
		frmCadastro.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(260, 77, 156, 20);
		frmCadastro.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(260, 102, 156, 20);
		frmCadastro.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(260, 127, 156, 20);
		frmCadastro.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(260, 152, 156, 20);
		frmCadastro.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(200, 266, 90, 23);
		frmCadastro.getContentPane().add(btnAdicionar);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(300, 266, 90, 23);
		frmCadastro.getContentPane().add(btnListar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(400, 266, 90, 23);

		frmCadastro.getContentPane().add(btnVoltar);

		JLabel lblNewLabel_5 = new JLabel("aaaa-mm-dd hh:mm:ss");
		lblNewLabel_5.setBounds(426, 102, 143, 14);
		frmCadastro.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("aaaa-mm-dd hh:mm:ss");
		lblNewLabel_6.setBounds(426, 127, 143, 14);
		frmCadastro.getContentPane().add(lblNewLabel_6);

		/**
		 * Insere funcao aos botoes
		 */

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((textField_1.getText().isEmpty()) || (textField_2.getText().isEmpty())
						|| (textField_3.getText().isEmpty()) || (textField_4.getText().isEmpty())
						|| (textField_5.getText().isEmpty()))
					JOptionPane.showMessageDialog(null, "Data Missing");
				else {
					dao.CadastroDao Anun = new dao.CadastroDao();
					Inicio = Timestamp.valueOf(textField_3.getText());
					Termino = Timestamp.valueOf(textField_4.getText());
					System.out.println(Termino);
					Anun.inserirAnuncio(textField_1.getText(), textField_2.getText(), Inicio, Termino,
							Double.parseDouble(textField_5.getText()));
					JOptionPane.showMessageDialog(null, "Visita criada");
				}
			}
		});

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dao.RelatorioDao anuncio = new dao.RelatorioDao();
				anuncio.listaAnuncios();
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCadastro.dispose();
				Menu.main(null);

			}
		});

	}
}
