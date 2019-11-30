package ch.Model.State.Pedido;

import ch.Model.Pedido;

public class StatusConcluido implements StatePedido{
	@Override
	public String estado(Pedido p) {
        p.setStatus(Status.CONCLUIDO);
        return "Pedido Concluido";
    }
}
