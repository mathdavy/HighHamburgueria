package ch.Model.State.Comanda;

import ch.Model.Comanda;

public interface StateComanda {
	public enum Status{
        ABERTA,FECHADA
    }

	public String estado(Comanda c);
}
