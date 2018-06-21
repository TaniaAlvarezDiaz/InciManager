package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Agent find(String identificador, String password, String tipo) {
		return agentRepository.find(identificador, password, tipo);
	}

}
