package ch.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class VboxMenuFuncionarioController implements Initializable{
	
	@FXML
    private MenuItem menuItemCadastrarComanda;

    @FXML
    private MenuItem menuItemAlterarComanda;

    @FXML
    private MenuItem menuItemFecharComanda;

    @FXML
    private MenuItem menuItemCadatrarPedido;

    @FXML
    private MenuItem menuItemAlterarPedido;

    @FXML
    private MenuItem menuItemListarComandas;

    @FXML
    private MenuItem menuItemListarPedidos;

    @FXML
    private AnchorPane anchorPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
