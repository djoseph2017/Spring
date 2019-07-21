package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String connectionUrl = "jdbc:sqlserver://localhost;databaseName=testdb;" + 
								"user=sa;password=72592780077qQ#";

		try (Connection connection = DriverManager.getConnection(connectionUrl);) {
			// Code here.
			System.out.println("Success");
			Statement stmt = connection.createStatement();
			String SQL = "Select TOP 10 * from Orders;";
			ResultSet rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getString("OrderID") + " " + rs.getString("OrderNumber"));

			}
			
			connection.close();

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
