package ch.Model.State.Comanda;

import ch.Model.Comanda;

public class StatusAberto implements StateComanda{
	@Override
	public String estado(Comanda c) {
		c.setStatus(Status.ABERTA);
        return "Comanda Aberta";
	}

}
