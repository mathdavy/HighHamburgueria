package ch.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import ch.Model.Comanda;
import ch.Model.Pedido;
import ch.Model.Produto;
import ch.Model.State.Pedido.StatusConcluido;
import ch.Model.State.Pedido.StatusEmAndamento;
import connection.ConnectionFactory;

public class PedidoDAO {
	
	private Connection connection;
	
	public PedidoDAO(){
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
	}
	
	public List<Pedido> read(){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Pedido> pedidos = new ArrayList<>();
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM pedido");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setIdPedido(rs.getInt("idPedido"));
				pedido.setComentario(rs.getString("comentario"));
				//pedido.getStatus()
				pedidos.add(pedido);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection, stmt, rs);
		}

		return pedidos;
	}

	public void create(Pedido p, Comanda c, Produto prod) {
		PreparedStatement stmt = null;
		
		PreparedStatement stmt2 = null;
		
		PreparedStatement stmt3 = null;
		
		PreparedStatement stmtGetIdPedido = null;
		ResultSet rsIdPedido = null;
		
		PreparedStatement stmtIdProduto = null;
		ResultSet rsIdProduto = null;
		
		
		
		try {
			stmt = connection.prepareStatement("INSERT INTO pedido (status, comentario) VALUES(?,?)");
			stmt.setString(1, new StatusEmAndamento().estado(p));
			stmt.setString(2, p.getComentario()); 
			stmt.executeUpdate();
			//System.out.println("Executou1");
			int idPedido = 0;
			int idProduto = 0;
			
			stmtGetIdPedido = connection.prepareStatement("SELECT idPedido FROM pedido ORDER BY idPedido DESC LIMIT 1");
			rsIdPedido = stmtGetIdPedido.executeQuery();
			while (rsIdPedido.next()){
				idPedido = rsIdPedido.getInt("idPedido");
			}
			
			//System.out.println("Executou2");
			
			stmt2 = connection.prepareStatement("INSERT INTO comanda_pedido (idComanda, idPedido) VALUES(?,?)");
			stmt2.setInt(1, c.getIdComanda());
			stmt2.setInt(2, idPedido);
			stmt2.executeUpdate();
			//System.out.println("Executou3");
			
			stmtIdProduto = connection.prepareStatement("SELECT idProduto FROM produto WHERE nome = ?");
			stmtIdProduto.setString(1, prod.getNome());
			rsIdProduto = stmtIdProduto.executeQuery();
			while (rsIdProduto.next()){
				idProduto = rsIdProduto.getInt("idProduto");
			}
			//System.out.println("Executou4");
			
			stmt3 = connection.prepareStatement("INSERT INTO pedido_produto(idPedido, idProduto) VALUES (?,?)");
			stmt3.setInt(1, idPedido);
			stmt3.setInt(2, idProduto);
			stmt3.executeUpdate();
			//System.out.println("Executou5");
			
			JOptionPane.showMessageDialog(null, "Pedido Realizado com sucesso.!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			
		}finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void create(Pedido p, Comanda c, Produto prod1, Produto prod2) {
		PreparedStatement stmt = null;
		
		PreparedStatement stmt2 = null;
		
		PreparedStatement stmt3 = null;
		
		PreparedStatement stmtGetIdPedido = null;
		ResultSet rsIdPedido = null;
		
		PreparedStatement stmtIdProduto = null;
		ResultSet rsIdProduto = null;
		
		
		
		try {
			stmt = connection.prepareStatement("INSERT INTO pedido (status, comentario) VALUES(?,?)");
			stmt.setString(1, new StatusEmAndamento().estado(p));
			stmt.setString(2, p.getComentario()); 
			stmt.executeUpdate();
			//System.out.println("Executou1");
			int idPedido = 0;
			int idProduto = 0;
			
			stmtGetIdPedido = connection.prepareStatement("SELECT idPedido FROM pedido ORDER BY idPedido DESC LIMIT 1");
			rsIdPedido = stmtGetIdPedido.executeQuery();
			while (rsIdPedido.next()){
				idPedido = rsIdPedido.getInt("idPedido");
			}
			
			//System.out.println("Executou2");
			
			stmt2 = connection.prepareStatement("INSERT INTO comanda_pedido (idComanda, idPedido) VALUES(?,?)");
			stmt2.setInt(1, c.getIdComanda());
			stmt2.setInt(2, idPedido);
			stmt2.executeUpdate();
			//System.out.println("Executou3");
			
			stmtIdProduto = connection.prepareStatement("SELECT idProduto FROM produto WHERE nome = ?");
			stmtIdProduto.setString(1, prod1.getNome());
			rsIdProduto = stmtIdProduto.executeQuery();
			while (rsIdProduto.next()){
				idProduto = rsIdProduto.getInt("idProduto");
			}
			//System.out.println("Executou4");
			
			stmt3 = connection.prepareStatement("INSERT INTO pedido_produto(idPedido, idProduto) VALUES (?,?)");
			stmt3.setInt(1, idPedido);
			stmt3.setInt(2, idProduto);
			stmt3.executeUpdate();
			//System.out.println("Executou5");
			
			stmtIdProduto = connection.prepareStatement("SELECT idProduto FROM produto WHERE nome = ?");
			stmtIdProduto.setString(1, prod2.getNome());
			rsIdProduto = stmtIdProduto.executeQuery();
			while (rsIdProduto.next()){
				idProduto = rsIdProduto.getInt("idProduto");
			}
			//System.out.println("Executou6");
			
			stmt3 = connection.prepareStatement("INSERT INTO pedido_produto(idPedido, idProduto) VALUES (?,?)");
			stmt3.setInt(1, idPedido);
			stmt3.setInt(2, idProduto);
			stmt3.executeUpdate();
			//System.out.println("Executou7");
			
			JOptionPane.showMessageDialog(null, "Pedido Realizado com sucesso.!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			
		}finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	
	public void update(Pedido p) {
		PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement("UPDATE pedido SET status = ? WHERE idPedido = ?");
			stmt.setString(1, new StatusConcluido().estado(p));
			stmt.setInt(2, p.getIdPedido());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			
		}finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
}
