package br.aeso.ex01Maur�cio.exerc�cio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getConnection() {

		String conexao = "jdbc:mysql://localhost/projeto01";
		String usuario = "root";
		String senha = "root";

		try {
			return DriverManager.getConnection(conexao, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public static void main(String args[]) {
		Connection conexao = JDBCConnection.getConnection();
		if (conexao == null)
			System.out.println("Conex�o falhou !");
		else
			System.out.println("Conex�o feita com sucesso !");
	}
}
