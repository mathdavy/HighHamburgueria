package ch.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ch.Model.Comanda;
import ch.Model.State.Comanda.StateComanda.Status;
import ch.Model.State.Comanda.StatusAberto;
import ch.Model.State.Comanda.StatusFechada;
import connection.ConnectionFactory;

public class ComandaDAO {
	private Connection connection;
	
	public ComandaDAO(){
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void create(Comanda c) {
		PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement("INSERT INTO comanda (Nome_Cliente, Telefone, Estado) VALUES(?,?,?)");
			stmt.setString(1, c.getNomeCliente());
			stmt.setString(2, c.getTelefoneCliente());  
			stmt.setString(3, new StatusAberto().estado(c));
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			
		}finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void update(Comanda c) {
		PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement("UPDATE comanda SET Estado = ? WHERE idComanda = ?"); 
			stmt.setInt(2, c.getIdComanda());
			stmt.setString(1, new StatusFechada().estado(c));
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			
		}finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public double getValorTotal(Comanda c){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		double valorTotal = 0;
		
		try {
			stmt = connection.prepareStatement("SELECT sum(preco) as Valor_total "
					+ "FROM comanda as c "
					+ "INNER JOIN comanda_pedido as cp "
					+ "ON cp.idComanda = c.idComanda "
					+ "INNER JOIN pedido as p "
					+ "ON cp.idPedido = p.idPedido "
					+ "INNER JOIN pedido_produto as pp "
					+ "ON p.idPedido = pp.idPedido "
					+ "INNER JOIN produto as prod "
					+ "ON pp.idProduto = prod.idProduto "
					+ "WHERE c.idComanda = ?;");
			
			stmt.setInt(1, c.getIdComanda());
			
			rs = stmt.executeQuery();
			
			while (rs.next()){
				valorTotal = rs.getDouble("Valor_total");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection, stmt, rs);
		}
		return valorTotal;
	}
	
	public List<Comanda> read(){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Comanda> comandas = new ArrayList<>();
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM comanda");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Comanda comanda = new Comanda();
				comanda.setIdComanda(rs.getInt("idComanda"));
				comanda.setNomeCliente(rs.getString("Nome_Cliente"));
				comanda.setTelefoneCliente(rs.getString("Telefone"));
				String estado = rs.getString("Estado");
				if(estado.equals("Comanda Fechada")) {
					comanda.setStatus(Status.FECHADA);
				}else {
					comanda.setStatus(Status.ABERTA);
				}
				
				comandas.add(comanda);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection, stmt, rs);
		}

		return comandas;
	}
}
