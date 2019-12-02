package ch.Controller;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import ch.DAO.ComandaDAO;
import ch.Model.Comanda;
import ch.util.connection.Conexao;
import ch.util.connection.ConexaoFactory;
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
    
    private final Conexao conexao = ConexaoFactory.getDatabase("mysql");
    private final Connection connection = conexao.conectar();
    private final ComandaDAO comandaDAO = new ComandaDAO();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comandaDAO.setConnection(connection);
		carregarTableViewComanda();
		
	}
	
	public void carregarTableViewComanda() {
		

		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("idComanda"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
		tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefoneCliente"));
		tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		
		listComanda = comandaDAO.read();
		
		obsListComanda = FXCollections.observableArrayList(listComanda);
		tableViwComanda.setItems(obsListComanda);

	}

}
