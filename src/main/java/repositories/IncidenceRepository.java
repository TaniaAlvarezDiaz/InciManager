package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Incidence;

public interface IncidenceRepository extends CrudRepository<Incidence, Long>{

	/**
	 * Método que devuelve una lista con las incidencias que tengan
	 * el estado que se pasa por parametro
	 * @param estado
	 * @return
	 */
	@Query("SELECT i FROM Incidence i WHERE i.estado = ?1")
	public List<Incidence> findByEstado(String estado);
	
	/**
	 * Método que devuelve una lista con las incidencias que 
	 * ha enviado el agente que se pasa por parametro
	 * @param agentIdentifier
	 * @return
	 */
	@Query("SELECT i FROM Incidence i WHERE i.agent.identificador = ?1")
	List<Incidence> findByAgent(String agentIdentifier);
	
	/**
	 * Método que devuelve una lista con las incidencias que 
	 * tiene asignadas el personal de gestion cuyo identificador
	 * se pasa por parametro
	 * @param identifier
	 * @return
	 */
	@Query("SELECT i FROM Incidence i WHERE i.incidentManagementStaff.identificador = ?1")
	List<Incidence> findByIncidentManagementStaff(String identifier);
	
}
