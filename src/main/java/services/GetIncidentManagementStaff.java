package services;

import model.IncidentManagementStaff;

public interface GetIncidentManagementStaff {

	public IncidentManagementStaff findByIdentificador(String identifier);
}
