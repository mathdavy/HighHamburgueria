package State;

import model.Pedido;

public class StatusConcluido implements State{
	public String estado(Pedido p) {
        p.setStatus(Status.CONCLUIDO);
        return "Pedido Concluido";
    }
}
