package ch.Model.State.Pedido;

import ch.Model.Pedido;

public interface StatePedido {

	public enum Status{
        EM_ANDAMENTO,CONCLUIDO
    }

	public String estado(Pedido p);
}
