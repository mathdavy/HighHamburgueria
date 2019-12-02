package ch.DAO;

import java.util.List;

import ch.Model.Comanda;
import ch.Model.Pedido;
import ch.Model.Produto;

public interface BasePedidoDAO {
	public List<Pedido> read();
	public void create(Pedido p, Comanda c, Produto prod);
	public void create(Pedido p, Comanda c, Produto prod1, Produto prod2);
	public void update(Pedido p);
}
