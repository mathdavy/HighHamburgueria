package ch.Model.State.Comanda;

import ch.Model.Comanda;

public class StatusFechada implements StateComanda{
	@Override
	public String estado(Comanda c) {
		c.setStatus(Status.FECHADA);
        return "Comanda Fechada";
	}
}
