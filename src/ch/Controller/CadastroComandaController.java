package ch.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ch.Model.Comanda;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



public class CadastroComandaController implements Initializable {

	@FXML
    private TableView<Comanda> tableViewComanda;

    @FXML
    private TableColumn<Comanda, String> tableColumnComandaCliente;

    @FXML
    private TableColumn<Comanda, String> tableColumnComandaTelefone;

    @FXML
    private Label labelComandaCodigo;

    @FXML
    private Label labelComandaCliente;

    @FXML
    private Label labelComandaTelefone;

    @FXML
    private Button buttonCadastrar;
    
    @FXML
    private Button buttonAlterar;
    
    private List<Comanda> listComanda;
    private ObservableList<Comanda> observableListComanda;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
