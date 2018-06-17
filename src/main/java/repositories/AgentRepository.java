package repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Agent;

public interface AgentRepository extends CrudRepository<Agent, Long>{

	@Query("SELECT a FROM Agent a WHERE a.identificador = ?1")
	public Agent findByIdentificador(String identifier);
}
