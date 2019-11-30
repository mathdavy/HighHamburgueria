package ch.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import ch.DAO.ComandaDAO;
import ch.Model.Comanda;
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

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	public void iniciarComanda(ActionEvent event) throws IOException {
		Comanda c = new Comanda();
		ComandaDAO dao = new ComandaDAO();
		c.setNomeCliente(textFieldNomeCliente.getText());
		c.setTelefoneCliente(textFieldTelefoneCliente.getText());
		dao.create(c);
	}
}
