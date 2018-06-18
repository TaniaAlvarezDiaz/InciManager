package services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.IncidentManagementStaff;

/**
 * Servicio para introducir datos en la base de datos
 * @author Tania Álvarez Díaz
 *
 */
@Service
public class InsertSampleData {

	@Autowired
	private IncidentManagementStaffService incidentManagementStaffService;
	
	@PostConstruct
	public void init() {
		 
		//Se inserta personal de gestion de incidencias
		List<IncidentManagementStaff> staff = new ArrayList<IncidentManagementStaff>();
		
		staff.add(new IncidentManagementStaff("Susana Pérez", "susan@gmail.com", "09847158T", "123456"));
		staff.add(new IncidentManagementStaff("Rodrigo Suárez", "rodrigo@gmail.com", "71856941S", "123456"));
		staff.add(new IncidentManagementStaff("Paola", "paola@gmail.com", "09847514P", "123456"));
		
		incidentManagementStaffService.saveIncidentManagementStaff(staff);
	}
}
