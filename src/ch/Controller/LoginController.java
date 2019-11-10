package ch.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	
	@FXML
	private Button buttonLogin;
	@FXML
	private TextField textFieldUsuario;
	@FXML
	private TextField textFieldSenha;
	
	@FXML
	public void Login(ActionEvent event) throws IOException {
		
		if(textFieldUsuario.getText().equals("user") && textFieldSenha.getText().equals("pass")) {
			
			Stage stage = new Stage();
				
			Parent root = FXMLLoader.load(getClass().getResource("View/VboxMenuFuncionario.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("High Hamburgueria");
			stage.setResizable(false);
			stage.show();
		}else {
				
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
}
