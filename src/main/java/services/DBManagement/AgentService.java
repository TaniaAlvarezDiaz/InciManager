package services.DBManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import model.Agent;
import repositories.AgentRepository;

@Service
public class AgentService implements GetAgent {

	@Autowired
	private AgentRepository agentRepository;

	@Override
	public Agent findByIdentificador(String identifier) {
		return agentRepository.findByIdentificador(identifier);
	}

}
