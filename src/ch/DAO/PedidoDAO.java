package ch.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch.Model.Pedido;
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
				pedido.setPreco(rs.getDouble("preco"));
				pedido.setComentario(rs.getString("comentario"));
				//pedido.getStatus()
				pedidos.add(pedido);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection, stmt, rs);
		}

		return pedidos;
	}
}
