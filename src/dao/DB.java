package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Classe que contem as informacoes para realizar a conexao com o bd 
 *
 */

public abstract class DB {
	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultset = null;

	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/Anuncio";
		String usuario = "root";
		String senha = "123456789";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}
}