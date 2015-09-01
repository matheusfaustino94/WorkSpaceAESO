package br.aeso.ex01Maurício.exercício.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploJDBC2 {

	public static void main(String[] args) throws SQLException {

		String conexao = "jdbc:mysql://localhost/projeto01";
		String usuario = "root";
		String senha = "root";
		
		Connection conn = DriverManager.getConnection(conexao, usuario, senha);

		String sql = "insert into projeto01.fornecedor (nome,cpf,banco)	values (?,?,?)";

		java.sql.PreparedStatement preStatement = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		preStatement.setString(1, "Matheus");
		preStatement.setString(2, "08460611479");
		preStatement.setString(3, "Itau");

		preStatement.execute();
		
		// Statement state = conn.createStatement();
		// state.executeQuery(queryStr); //"executeQuery" somente para CONSULTAS
		// state.execute(queryStr); //"execute" somente para INSERT
		// ResultSet rs = state.executeQuery(queryStr);

	}

}
