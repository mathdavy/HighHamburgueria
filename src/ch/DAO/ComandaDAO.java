package ch.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ch.Model.Comanda;
import connection.ConnectionFactory;

public class ComandaDAO {
	
	public void create(Comanda c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO comanda (idComanda, Nome_Cliente, Telefone) VALUES(?,?,?)");
			stmt.setInt (1, c.getIdComanda());
			stmt.setString(2, c.getNomeCliente());
			stmt.setString(3, c.getTelefoneCliente());  
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
