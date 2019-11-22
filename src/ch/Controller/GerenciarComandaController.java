package ch.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GerenciarComandaController {
	
	@FXML
    private Label labelNomeDoFuncionario;

    @FXML
    private Button buttonIniciarComanda;

    @FXML
    private Button buttonHistorico;

    @FXML
    private Button buttonFinalizarComanda;
    
    @FXML
    void FinalizarComanda(ActionEvent event) {
    	try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ch/View/FecharComanda.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.setTitle("High Hamburgueria");
		    stage.setScene(new Scene(root1));  
		    stage.show();
		    
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
    }

    @FXML
    void HistoricoComanda(ActionEvent event) {
    	
    }

    @FXML
    void IniciarComanda(ActionEvent event) {
    	try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ch/View/CriarComanda.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.setTitle("High Hamburgueria");
		    stage.setScene(new Scene(root1));  
		    stage.show();
		    
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
    }
}
