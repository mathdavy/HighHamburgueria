package ch.DAO;

import java.util.List;
import ch.Model.Comanda;

public interface BaseComandaDAO {
	public void create(Comanda c);
	public void update(Comanda c);
	public double getValorTotal(Comanda c);
	public List<Comanda> read();
}
