package services.DBManagement;

import model.Agent;

public interface GetAgent {

	public Agent findByIdentificador(String identifier);
}
