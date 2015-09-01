package br.aeso.ex01Maurício.exercício.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploJDBC {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.168.2.3/matheus_bd", "root", "root");
		
		String queryStr = "insert into cliente (nome,cpf,banco)	values ('João','123456722','Bradesco')";

		Statement state = conn.createStatement();
		//state.executeQuery(queryStr); //"executeQuery" somente para CONSULTAS
		state.execute(queryStr); //"execute" somente para INSERT
		//ResultSet rs = 

		//Fornecedor fornecedor = new Fornecedor();

		/*while (rs != null && rs.next()) {

			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			String banco = rs.getString("banco");

			fornecedor.setBanco(banco);
			fornecedor.setCpf(cpf);
			fornecedor.setNome(nome);
			System.out.println(fornecedor.toString());
			System.out.println(rs.getString(1));
		}*/

	}

}
