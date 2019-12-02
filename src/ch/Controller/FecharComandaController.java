package ch.Controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ch.DAO.ComandaDAO;
import ch.DAO.ProdutoDAO;
import ch.Model.Comanda;
import ch.Model.Produto;
import ch.util.connection.Conexao;
import ch.util.connection.ConexaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FecharComandaController implements Initializable{
	@FXML
    private Button buttonFecharComanda;

    @FXML
    private TextField textFieldIDComanda;

    @FXML
    private TextArea textAreaInfoComanda;

    @FXML
    private Button buttonBuscarComanda;
    
    private List<Produto> produtos = new ArrayList<>();

    @FXML
    void CloseComanda(ActionEvent event) {
    	
    	final Conexao conexao = ConexaoFactory.getDatabase("mysql");
        final Connection connection = conexao.conectar();
        final ComandaDAO comandaDAO = new ComandaDAO();
        comandaDAO.setConnection(connection);
    	
    	
    	Comanda c = new Comanda();
    	c.setIdComanda(Integer.parseInt(textFieldIDComanda.getText()));
    	comandaDAO.update(c);
    }

    @FXML
    void SearchComanda(ActionEvent event) {
    	
    	final Conexao conexao = ConexaoFactory.getDatabase("mysql");
        final Connection connection = conexao.conectar();
        final ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.setConnection(connection);
        
        final Conexao conexao2 = ConexaoFactory.getDatabase("mysql");
        final Connection connection2 = conexao2.conectar();
        final ComandaDAO comandaDAO = new ComandaDAO();
        
        comandaDAO.setConnection(connection2);
        

    	textAreaInfoComanda.clear();
    	produtos.clear();
    	String texto= "";
    	Comanda c = new Comanda();
    	c.setIdComanda(Integer.parseInt(textFieldIDComanda.getText()));
    	
		for(Produto p: produtoDAO.read(c)) {
			produtos.add(p);
		}
		
		for(Produto p: produtos) {
			texto += p.getNome() + ": " + p.getDescricao();
			texto += "\n";
		}
		
		double valorTotal = comandaDAO.getValorTotal(c);
		texto += "\nPreço total: " + valorTotal;
		
		textAreaInfoComanda.setText(texto);
		
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
