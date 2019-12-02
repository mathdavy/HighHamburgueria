package ch.Controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import ch.DAO.PedidoDAO;
import ch.DAO.ProdutoDAO;
import ch.Model.Comanda;
import ch.Model.Pedido;
import ch.Model.Produto;
import ch.util.connection.Conexao;
import ch.util.connection.ConexaoFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FazerPedidoController implements Initializable{

	@FXML
    private AnchorPane anchorPaneIniciarComanda;

    @FXML
    private Button buttonIniciarPedido;

    @FXML
    private TextField textFieldIDComanda;

    @FXML
    private TextArea txtAreaComent;

    @FXML
    private ComboBox<Produto> cbHamburguer;
    
    @FXML
    private ComboBox<Produto> cbBebidas;
    
    private List<Produto> produtos = new ArrayList<>();
    
    private ObservableList<Produto> obsHamburg;
    
    private ObservableList<Produto> obsBebida;
    
    @FXML
    void IniciarPedido(ActionEvent event) {
    	final Conexao conexao = ConexaoFactory.getDatabase("mysql");
        final Connection connection = conexao.conectar();
        final PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.setConnection(connection);
        
    	try {
    		
    		if(textFieldIDComanda.getText() != null) {
	    		Comanda comanda = new Comanda();
		    	comanda.setIdComanda(Integer.parseInt(textFieldIDComanda.getText()));
		    	
		    	if(cbHamburguer.getValue() == null && cbBebidas.getValue()!=null) {
		    		
		    		Produto bebida = cbBebidas.getValue();
		    		Comanda c = new Comanda();
		    		c.setIdComanda(Integer.parseInt(textFieldIDComanda.getText()));
		    		
		    		Pedido p = new Pedido();
		    		p.setComentario(txtAreaComent.getText());
		    		
		    		
		    		pedidoDAO.create(p, c, bebida);
		    		
		    		
		    	}else if(cbHamburguer.getValue() != null && cbBebidas.getValue()== null) {
		    		Produto hamburguer = cbHamburguer.getValue();
		    		Comanda c = new Comanda();
		    		c.setIdComanda(Integer.parseInt(textFieldIDComanda.getText()));
		    		
		    		Pedido p = new Pedido();
		    		p.setComentario(txtAreaComent.getText());
		    		
		    		
		    		pedidoDAO.create(p, c, hamburguer);
		    		
		    	}else {
		    		Produto hamburguer = cbHamburguer.getValue();
			    	Produto bebida = cbBebidas.getValue();
			    	
			    	Comanda c = new Comanda();
		    		c.setIdComanda(Integer.parseInt(textFieldIDComanda.getText()));
		    		
		    		Pedido p = new Pedido();
		    		p.setComentario(txtAreaComent.getText());
		    		
		    		
		    		pedidoDAO.create(p, c, hamburguer, bebida);
					
		    	}
				buttonIniciarPedido.getScene().getWindow().hide();
    		}
			
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null,  e);
    		buttonIniciarPedido.getScene().getWindow().hide();
    	}
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		final Conexao conexao = ConexaoFactory.getDatabase("mysql");
        final Connection connection = conexao.conectar();
        final ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.setConnection(connection);
		
		for(Produto p: produtoDAO.read()) {
			produtos.add(p);
		}
		carregarComboBoxHamburg();
		carregarComboBoxBebidas();
		
	}
	
	public void carregarComboBoxHamburg() {
		obsHamburg = FXCollections.observableArrayList(produtos);
		cbHamburguer.setItems(obsHamburg);
	}
	
	public void carregarComboBoxBebidas() {
		obsBebida = FXCollections.observableArrayList(produtos);
		cbBebidas.setItems(obsBebida);
	}
}
