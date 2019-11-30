package ch.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ch.DAO.ComandaDAO;
import ch.DAO.ProdutoDAO;
import ch.Model.Comanda;
import ch.Model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FecharComandaController implements Initializable{
	@FXML
    private Button buttonFecharComanda;

    @FXML
    private TextField textFieldIDComanda;

    @FXML
    private TextArea textAreaInfoComanda;

    @FXML
    private Button buttonBuscarComanda;
    
    private List<Produto> produtos = new ArrayList<>();

    @FXML
    void CloseComanda(ActionEvent event) {
    	ComandaDAO dao = new ComandaDAO();
    	Comanda c = new Comanda();
    	c.setIdComanda(Integer.parseInt(textFieldIDComanda.getText()));
    	dao.update(c);
    }

    @FXML
    void SearchComanda(ActionEvent event) {
    	textAreaInfoComanda.clear();
    	produtos.clear();
    	String texto= "";
    	ProdutoDAO dao = new ProdutoDAO();
    	Comanda c = new Comanda();
    	c.setIdComanda(Integer.parseInt(textFieldIDComanda.getText()));
    	
		for(Produto p: dao.read(c)) {
			produtos.add(p);
		}
		
		for(Produto p: produtos) {
			System.out.println(p.getNome());
		}
		
		for(Produto p: produtos) {
			texto += p.getNome() + ": " + p.getDescricao();
			texto += "\n";
		}
		
		textAreaInfoComanda.setText(texto);
		
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
