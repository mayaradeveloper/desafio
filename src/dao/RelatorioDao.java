package dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RelatorioDao extends DB {
	/**
	 * Conecta com o bd
	 */
	public RelatorioDao() {
		this.conectar();
	}

	/**
	 * Abre uma query para o banco de dados pedindo todas as informacoes da tabela
	 * DADOS.
	 */

	public void listaAnuncios() {
		try {
			String query = "select * from DADOS";
			this.resultset = this.statement.executeQuery(query);
			ArrayList<String> listadeAnuncios = new ArrayList<>();
			while (this.resultset.next()) {

				listadeAnuncios.add(" Nome do anuncio : " + this.resultset.getString("NOMEDOANUNCIO") + " || Cliente : "
						+ this.resultset.getString("CLIENTE") + " || Data Inicio : "
						+ this.resultset.getTimestamp("DATAINICIO") + " || Data de Termino : "
						+ this.resultset.getTimestamp("DATATERMINO") + " || Investimento por dia : R$ "
						+ this.resultset.getDouble("INVESTIMENTOPORDIA") + " \n");
			}
			JOptionPane.showMessageDialog(null,
					listadeAnuncios.toString().replace("[", "").replace("]", "").replace(",", ""));
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/**
	 * Abre uma query para o banco de dados pedindoo todas as informacoes que estao
	 * entre os 2 data na tabela DADOS.
	 */

	public void listdataAnuncios(Timestamp from, Timestamp to) {
		try {
			String query = "select * from DADOS where DATAINICIO and DATATERMINO between '" + from + "' and '" + to
					+ "';";
			this.resultset = this.statement.executeQuery(query);
			ArrayList<String> listadeAnuncios = new ArrayList<>();
			while (this.resultset.next()) {
				listadeAnuncios.add(" Valor total investido : " + this.resultset.getString("VALORTOTALINVESTIDO")
						+ " || Cliente : " + this.resultset.getString("NOMEDOANUNCIO")
						+ this.resultset.getString("CLIENTE") + " || Data Inicio : "
						+ this.resultset.getTimestamp("DATAINICIO") + " || Data de Termino : "
						+ this.resultset.getTimestamp("DATATERMINO") + " || Investimento por dia : R$ "
						+ this.resultset.getDouble("INVESTIMENTOPORDIA") + " || Valor Total investido : R$ "
						+ this.resultset.getDouble("VALORTOTALINVESTIDO") + " || Numero maximo de views : "
						+ this.resultset.getDouble("MAXVIEWS") + " || Numero maximo de clicks : "
						+ this.resultset.getDouble("MAXCLICKS") + " || Numero maximo de compartilhamentos : "
						+ this.resultset.getDouble("MAXSHARES") + " \n");
			}
			JOptionPane.showMessageDialog(null,
					listadeAnuncios.toString().replace("[", "").replace("]", "").replace(",", ""));
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/**
	 * Abre uma query para o banco de dados pedidno todas as informacoes que
	 * correspondem a determinado cliente na tabela DADOS.
	 */

	public void listClienteAnuncios(String Cliente) {
		try {
			String query = "select * from DADOS where CLIENTE ='" + Cliente + "';";
			this.resultset = this.statement.executeQuery(query);
			ArrayList<String> listadeAnuncios = new ArrayList<>();
			while (this.resultset.next()) {
				listadeAnuncios.add(" Valor total investido : " + this.resultset.getString("VALORTOTALINVESTIDO")
						+ " || Cliente : " + this.resultset.getString("NOMEDOANUNCIO")
						+ this.resultset.getString("CLIENTE") + " || Data Inicio : "
						+ this.resultset.getTimestamp("DATAINICIO") + " || Data de Termino : "
						+ this.resultset.getTimestamp("DATATERMINO") + " || Investimento por dia : R$ "
						+ this.resultset.getDouble("INVESTIMENTOPORDIA") + " || Valor Total investido : R$ "
						+ this.resultset.getDouble("VALORTOTALINVESTIDO") + " || Numero maximo de views : "
						+ this.resultset.getDouble("MAXVIEWS") + " || Numero maximo de clicks : "
						+ this.resultset.getDouble("MAXCLICKS") + " || Numero maximo de compartilhamentos : "
						+ this.resultset.getDouble("MAXSHARES") + " \n");
			}
			JOptionPane.showMessageDialog(null,
					listadeAnuncios.toString().replace("[", "").replace("]", "").replace(",", ""));
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
