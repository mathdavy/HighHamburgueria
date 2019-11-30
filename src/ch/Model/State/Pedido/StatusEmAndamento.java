package ch.Model.State.Pedido;

import ch.Model.Pedido;

public class StatusEmAndamento implements StatePedido{
	@Override
	public String estado(Pedido p) {
        p.setStatus(Status.EM_ANDAMENTO);
        return "Pedido Em Andamento";
    }
}
