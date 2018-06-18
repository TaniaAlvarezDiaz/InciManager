package services;

import java.util.List;

import model.IncidentManagementStaff;

public interface GetIncidentManagementStaff {

	public IncidentManagementStaff findByIdentificador(String identifier);
	
	public List<IncidentManagementStaff> findAll();
}
