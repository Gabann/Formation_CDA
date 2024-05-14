package jdbc.tp_zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T>
{
	protected Connection connection;
	protected PreparedStatement preparedStatement;
	protected String request;
	protected ResultSet resultSet;

	protected BaseDAO(Connection connection)
	{
		this.connection = connection;
	}

	public abstract T create(T element) throws SQLException;

	public abstract T update(T element) throws SQLException;

	public abstract boolean delete(T element) throws SQLException;

	public abstract T getById(int id) throws SQLException;

	public abstract List<T> get() throws SQLException;
}
