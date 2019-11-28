package ch.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import ch.DAO.ProdutoDAO;
import ch.Model.Comanda;
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
    private Button buttonIniciarPedido;

    @FXML
    private TextField textFieldIDComanda;

    @FXML
    private TextArea txtAreaComent;

    @FXML
    private ComboBox<Produto> cbHamburguer;
    
    @FXML
    private ComboBox<Produto> cbBebidas;

    @FXML
    private ComboBox<Produto> cbPorcDoce;
    
    private List<Produto> produtos = new ArrayList<>();
    
    private ObservableList<Produto> obsHamburg;
    
    private ObservableList<Produto> obsBebida;
    
    private ObservableList<Produto> obsVariado;
    
    @FXML
    void IniciarPedido(ActionEvent event) {
    	Comanda comanda = new Comanda();
    	comanda.setIdComanda(Integer.parseInt(textFieldIDComanda.getText()));
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ProdutoDAO dao = new ProdutoDAO();
		for(Produto p: dao.read()) {
			produtos.add(p);
		}
		carregarComboBoxHamburg();
		carregarComboBoxBebidas();
		carregarComboBoxVariados();
	}
	
	public void carregarComboBoxHamburg() {
		obsHamburg = FXCollections.observableArrayList(produtos);
		cbHamburguer.setItems(obsHamburg);
	}
	
	public void carregarComboBoxBebidas() {
		obsBebida = FXCollections.observableArrayList(produtos);
		cbBebidas.setItems(obsBebida);
	}
	
	public void carregarComboBoxVariados() {
		obsVariado = FXCollections.observableArrayList(produtos);
		cbPorcDoce.setItems(obsVariado);
	}
  
}
