package ch.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import ch.DAO.FuncionarioDAO;
import ch.util.connection.Conexao;
import ch.util.connection.ConexaoFactory;
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
	
	private final Conexao conexao = ConexaoFactory.getDatabase("mysql");
    private final Connection connection = conexao.conectar();
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	@FXML
    void checkLogin(ActionEvent event)  throws IOException{
		if(funcionarioDAO.checkLogin(textFieldUsuario.getText(), textFieldSenha.getText())) {
			try{
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ch/View/MenuFuncionario.fxml"));
			    Parent root1 = (Parent) fxmlLoader.load();
			    Stage stage = new Stage();
			    stage.setTitle("High Hamburgueria");
			    stage.setScene(new Scene(root1));  
			    stage.show();
			    cancelLogin();
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
		}else {
			JOptionPane.showMessageDialog(null, "Senha incorreta");
		}	
    }
	
	public void cancelLogin() {
		buttonLogin.getScene().getWindow().hide();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		funcionarioDAO.setConnection (connection);
	}
	
}
