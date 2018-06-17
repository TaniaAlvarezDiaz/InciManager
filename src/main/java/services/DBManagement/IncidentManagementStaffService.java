package services.DBManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.IncidentManagementStaff;
import repositories.IncidentManagementStaffRepository;

@Service
public class IncidentManagementStaffService implements GetIncidentManagementStaff{

	@Autowired
	private IncidentManagementStaffRepository incidentManagementStaffRepository;
	
	@Override
	public IncidentManagementStaff findByIdentificador(String identifier) {
		return incidentManagementStaffRepository.findByIdentificador(identifier);
	}

}
