package repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.IncidentManagementStaff;

public interface IncidentManagementStaffRepository extends CrudRepository<IncidentManagementStaff, Long>{

	@Query("SELECT a FROM IncidentManagementStaff a WHERE a.identificador = ?1")
	public IncidentManagementStaff findByIdentificador(String identifier);
}
