package ch.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuFuncionarioController implements Initializable{
	
	@FXML
	private Button buttonCadastrarComanda;
	@FXML
	private Button buttonFazerPedido;
	@FXML
	private Button buttonAlterarPedido;
	@FXML
	private Button buttonFinalizarComanda;
	@FXML
	private Button buttonHistoricoPedidos;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
    void FazerPedido(ActionEvent event) {
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ch/View/FazerPedido.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.setTitle("High Hamburgueria");
		    stage.setScene(new Scene(root1));  
		    stage.show();
		    
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
    }

    @FXML
    void GerenciaComanda(ActionEvent event) {
    	try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ch/View/GerenciarComanda.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.setTitle("High Hamburgueria");
		    stage.setScene(new Scene(root1));  
		    stage.show();
		    
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
    }
	
}
