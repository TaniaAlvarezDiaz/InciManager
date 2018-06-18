package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import model.IncidentManagementStaff;
import repositories.IncidentManagementStaffRepository;

@Service
public class IncidentManagementStaffService implements GetIncidentManagementStaff, SaveIncidentManagementStaff{

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; // la contraseña se guarda cifrada
	
	@Autowired
	private IncidentManagementStaffRepository incidentManagementStaffRepository;
	
	@Override
	public IncidentManagementStaff findByIdentificador(String identifier) {
		return incidentManagementStaffRepository.findByIdentificador(identifier);
	}

	@Override
	public List<IncidentManagementStaff> findAll() {
		return (List<IncidentManagementStaff>) incidentManagementStaffRepository.findAll();
	}

	@Override
	public void saveIncidentManagementStaff(IncidentManagementStaff staff) {
		// se cifra la contraseña
		staff.setPassword(bCryptPasswordEncoder.encode(staff.getPassword()));
		incidentManagementStaffRepository.save(staff);
	}

	@Override
	public void saveIncidentManagementStaff(List<IncidentManagementStaff> staff) {
		for (IncidentManagementStaff s : staff)
			saveIncidentManagementStaff(s);
	}
	
	/**
	 * Método para obtener una persona de gestion de incidencias
	 * de forma aleatoria para asignarle la incidencia
	 * @return
	 */
	public IncidentManagementStaff obtenerUnOperadorAleatoriamente() {
		List<IncidentManagementStaff> staff = findAll();
		int aleatorio = (int) Math.floor(Math.random() * staff.size());
		return staff.get(aleatorio);		
	}
	
}
