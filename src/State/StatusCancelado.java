package State;

import Model.Pedido;

public class StatusCancelado implements State{
	public String estado(Pedido p) {
        p.setStatus(Status.CANCELADO);
        return "Pedido Cancelado";
	}
}
