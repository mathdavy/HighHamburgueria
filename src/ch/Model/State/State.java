package ch.Model.State;

import ch.Model.Pedido;

public interface State {

	public enum Status{
        EM_ANDAMENTO,CONCLUIDO
    }

	public String estado(Pedido p);
}
