package ch.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
}
