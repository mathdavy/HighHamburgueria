package ch.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ch.DAO.ComandaDAO;
import ch.Model.Comanda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HistoricoComandasController implements Initializable{
	
	@FXML
    private TableView<Comanda> tableViwComanda;
	
	@FXML
    private TableColumn<Comanda, String> tableColumnID;

    @FXML
    private TableColumn<Comanda, String> tableColumnNome;

    @FXML
    private TableColumn<Comanda, String> tableColumnTelefone;
	
    @FXML
    private TableColumn<Comanda, String> tableColumnStatus;
    
    private List<Comanda> listComanda;
    private ObservableList<Comanda> obsListComanda;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTableViewComanda();
		
	}
	
	public void carregarTableViewComanda() {
		ComandaDAO dao = new ComandaDAO();

		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("idComanda"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
		tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefoneCliente"));
		tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		
		listComanda = dao.read();
		
		obsListComanda = FXCollections.observableArrayList(listComanda);
		tableViwComanda.setItems(obsListComanda);

	}

}
