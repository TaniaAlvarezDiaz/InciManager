package services.DBManagement;

import model.IncidentManagementStaff;

public interface GetIncidentManagementStaff {

	public IncidentManagementStaff findByIdentificador(String identifier);
}
