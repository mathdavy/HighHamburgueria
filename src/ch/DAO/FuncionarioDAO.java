package ch.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ch.util.connection.ConexaoMySQL;

public class FuncionarioDAO implements BaseFuncionarioDAO, BaseDAO{
	
	private Connection connection;
	
	@Override
	public Connection getConnection() {
	    return connection;
	}
	
	@Override
	public void setConnection(Connection connection) {
	    this.connection = connection;
	}
	
	@Override
	public boolean checkLogin(String login, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;
        try {
            stmt = connection.prepareStatement("SELECT * FROM funcionario WHERE usuario = ? AND senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {

            	check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoMySQL.closeConnection(connection, stmt, rs);
        }

        return check;

    }
	
}
