package State;

import Model.Pedido;

public interface State {

	public enum Status{
        EM_ANDAMENTO,CONCLUIDO,CANCELADO
    }

	public String estado(Pedido p);
}
