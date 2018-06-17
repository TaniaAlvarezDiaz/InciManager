package services.DBManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Incidence;
import repositories.IncidenceRepository;

@Service
public class IncidenceService implements GetIncidences, SaveIncidence{

	@Autowired
	private IncidenceRepository incidenceRepository;
	
	@Override
	public List<Incidence> findByEstado(String estado) {
		return incidenceRepository.findByEstado(estado);
	}

	@Override
	public List<Incidence> findByAgent(String agentIdentifier) {
		return incidenceRepository.findByAgent(agentIdentifier);
	}

	@Override
	public List<Incidence> findByIncidentManagementStaff(String identifier) {
		return incidenceRepository.findByIncidentManagementStaff(identifier);
	}

	@Override
	public void saveIncidence(Incidence incidence) {
		incidenceRepository.save(incidence);
	}

}
