package ch.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ch.DAO.ProdutoDAO;
import ch.Model.Produto;
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
    private Button buttonIniciarComanda;

    @FXML
    private TextField textFieldIDComanda;

    @FXML
    private TextArea txtAreaComent;

    @FXML
    private ComboBox<?> cbProdutos;

    @FXML
    void IniciarComanda(ActionEvent event) {

    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ProdutoDAO dao = new ProdutoDAO();
		/*List<Produto> produtos = new ArrayList<>();
		
		for(Produto p: dao.read()) {
			produtos.add(p);
		}
		
		for(Produto p: produtos) {
			
		}*/
		
		
		
		
		
		
	}
    
    
	
}
