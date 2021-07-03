package dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadastroDao extends DB {

	/**
	 * Conecta com o bd
	 */
	public CadastroDao() {
		this.conectar();
	}

	/**
	 * Abre uma query para o banco de dados pedindo para inserir as informacoes
	 * contidas na String query na TABELA DADOS. Sei que e meio porco, mas deixei os
	 * calculos para os valores pedidos nessa classe tambem
	 */

	public void inserirAnuncio(String nomeAnuncio, String cliente, Timestamp dataInicio, Timestamp dataTermino,
			double investimentoPorDia) {
		try {
			int dataInicial = dataInicio.getDate();
			int dataFinal = dataTermino.getDate();
			int diff = dataFinal - dataInicial;
			Double totalInves = new Double(diff * investimentoPorDia);
			System.out.println(totalInves);
			double maxviews = (((investimentoPorDia * 30) * 2.88) * diff);
			double maxclicks = (((investimentoPorDia * 30) * 0.345623) * diff);
			double maxshares = (((investimentoPorDia * 30) * 0.04700833333) * diff);
			String query = "insert into DADOS (NOMEDOANUNCIO, CLIENTE, DATAINICIO, DATATERMINO, INVESTIMENTOPORDIA,VALORTOTALINVESTIDO, MAXVIEWS, MAXCLICKS, MAXSHARES) values ('"
					+ nomeAnuncio + "', '" + cliente + "', '" + dataInicio + "','" + dataTermino + "','"
					+ investimentoPorDia + "','" + totalInves + "','" + maxviews + "','" + maxclicks + "','" + maxshares
					+ "');";
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * fecha a conexao com o bd
	 */
	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}