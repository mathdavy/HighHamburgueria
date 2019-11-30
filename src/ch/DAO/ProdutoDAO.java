package ch.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch.Model.Comanda;
import ch.Model.Produto;
import connection.ConnectionFactory;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO(){
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
	}
	
	public List<Produto> read(){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produtos = new ArrayList<>();
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM produto");
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
		return produtos;
	}
	
	public List<Produto> read(Comanda c){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produtos = new ArrayList<>();
		
		try {
			stmt = connection.prepareStatement("SELECT prod.idProduto, prod.nome, prod.descricao, prod.preco "
					+ "FROM comanda as c "
					+ "INNER JOIN comanda_pedido as cp "
					+ "ON cp.idComanda = c.idComanda "
					+ "INNER JOIN pedido as p "
					+ "ON cp.idPedido = p.idPedido "
					+ "INNER JOIN pedido_produto as pp "
					+ "ON p.idPedido = pp.idPedido "
					+ "INNER JOIN produto as prod "
					+ "ON pp.idProduto = prod.idProduto "
					+ "WHERE c.idComanda = ?");
			
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
		return produtos;
	}
	
	
}
