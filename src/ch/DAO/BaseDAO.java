package ch.DAO;

import java.sql.Connection;

public interface BaseDAO {
	public Connection getConnection();
	public void setConnection(Connection connection);
}
