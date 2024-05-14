package jdbc.tp_zoo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager
{
	private static final String URI = "jdbc:mysql://localhost:3306/demo_jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "qwfpgj";

	public static Connection getConnection() throws SQLException
	{
		Connection connection = DriverManager.getConnection(URI, USER, PASSWORD);
		connection.setAutoCommit(false);
		System.out.println("Connection established");
		return connection;
	}
}
