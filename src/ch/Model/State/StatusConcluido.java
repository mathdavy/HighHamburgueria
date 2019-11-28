package ch.Model.State;

import ch.Model.Pedido;

public class StatusConcluido implements State{
	@Override
	public String estado(Pedido p) {
        p.setStatus(Status.CONCLUIDO);
        return "Pedido Concluido";
    }
}
