package services.DBManagement;

import java.util.List;

import model.Incidence;

public interface GetIncidences {

	public List<Incidence> findByEstado(String estado);

	public List<Incidence> findByAgent(String agentIdentifier);

	public List<Incidence> findByIncidentManagementStaff(String identifier);

}
