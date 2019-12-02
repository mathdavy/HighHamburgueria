package ch.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import ch.DAO.ComandaDAO;
import ch.Model.Comanda;
import ch.util.connection.Conexao;
import ch.util.connection.ConexaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class CadastroComandaController implements Initializable {

	@FXML
    private AnchorPane anchorPaneIniciarComanda;

    @FXML
    private Button buttonIniciarComanda;

    @FXML
    private TextField textFieldNomeCliente;

    @FXML
    private TextField textFieldTelefoneCliente;

    private final Conexao conexao = ConexaoFactory.getDatabase("mysql");
    private final Connection connection = conexao.conectar();
    private final ComandaDAO comandaDAO = new ComandaDAO();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comandaDAO.setConnection(connection);
	}
	
	@FXML
	public void iniciarComanda(ActionEvent event) throws IOException {
		Comanda c = new Comanda();
		c.setNomeCliente(textFieldNomeCliente.getText());
		c.setTelefoneCliente(textFieldTelefoneCliente.getText());
		comandaDAO.create(c);
	}
}
