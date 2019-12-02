package ch.DAO;

import java.util.List;

import ch.Model.Comanda;
import ch.Model.Produto;

public interface BaseProdutoDAO {
	public List<Produto> read();
	public List<Produto> read(Comanda c);
}
