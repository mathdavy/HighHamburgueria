package ch.Model.State;

import ch.Model.Pedido;

public class StatusEmAndamento implements State{
	@Override
	public String estado(Pedido p) {
        p.setStatus(Status.EM_ANDAMENTO);
        return "Pedido Em Andamento";
    }
}
