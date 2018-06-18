package services;

import model.Agent;

public interface GetAgent {

	public Agent findByIdentificador(String identifier);
	public Agent find(String identificador, String password, String tipo);
}
