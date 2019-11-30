package ch.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import ch.Model.Comanda;
import ch.Model.Produto;
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
	
	public double read(Comanda c){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produtos = new ArrayList<>();
		
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
					+ "WHERE c.idComanda = 7;");
			
			stmt.setInt(1, c.getIdComanda());
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setNome(rs.getString("nome"));
				produtos.add(produto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection, stmt, rs);
		}
		return 0;
	}
}
