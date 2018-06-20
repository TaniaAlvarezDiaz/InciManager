package services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import apacheKafka.SendIncidence;
import model.Agent;
import model.Incidence;
import model.Incidence.Estado;
import model.Property;
import repositories.IncidenceRepository;

@Service
@EnableJpaRepositories(basePackages = {"repositories"})
@EntityScan(basePackages = {"model"})
public class IncidenceService implements GetIncidences, SaveIncidence{

	@Autowired
	private SendIncidence sendIncidence;
	
	@Autowired
	private IncidenceRepository incidenceRepository;
	
	@Autowired
	private IncidentManagementStaffService incidentManagementStaffService;
	
	@Override
	public List<Incidence> findByEstado(String estado) {
		return incidenceRepository.findByEstado(estado);
	}

	@Override
	public List<Incidence> findByAgent(String agentIdentifier) {
		return incidenceRepository.findByAgent(agentIdentifier);
	}

	@Override
	public List<Incidence> findByIncidentManagementStaff(String identifier) {
		return incidenceRepository.findByIncidentManagementStaff(identifier);
	}

	@Override
	public void saveIncidence(Incidence incidence) {
		incidenceRepository.save(incidence);
	}

	/**
	 * Método que crea una incidencia
	 * @param name
	 * @param description
	 * @param tagsWeb
	 * @param propertiesWeb
	 * @param agent
	 * @return
	 */
	public Incidence createIncidence(String name, String description, String tagsWeb, String propertiesWeb, Agent agent) {
		
		// Obtenemos los tags y las propiedades
		Set<String> tags = procesarEtiquetas(tagsWeb);
		Set<Property> properties = procesarPropiedades(propertiesWeb);

		// Las incidencias caducan por defecto 1 mes  desde el momento en que se crean
		Calendar fechaCaducidad = Calendar.getInstance();
		fechaCaducidad.add(Calendar.MONTH, 1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String caducidad = formatter.format(fechaCaducidad.getTime());
	
		return new Incidence(name, description, Estado.ABIERTA, agent, tags, properties, caducidad);
	}
	
	/**
	 * Método que obtiene una lista de las etiquetas
	 * que introdujo el usuario en forma de string
	 * @param field
	 * @return
	 */
	private Set<String> procesarEtiquetas(String field) {
		if(field == null)
			return null;
		
		Set<String> list = new HashSet<String>();
		for (String string : field.split(";")) {
			list.add(string);
		}
		return list;
	}

	/**
	 * Método que obtiene una lista de las propiedades
	 * que introdujo el usuario en forma de string
	 * @param tagsWeb
	 * @return
	 */
	private Set<Property> procesarPropiedades(String tagsWeb) {
		if(tagsWeb == null)
			return null;
		
		Set<String> list = procesarEtiquetas(tagsWeb);

		Set<Property> propiedades = new HashSet<Property>();
		for (String s : list) {
			String[] temp = s.split(":");
			if (temp.length == 2) {
				Property pro = new Property(temp[0], temp[1]);
				propiedades.add(pro);
			}
		}
		return propiedades;
	}
	
	/**
	 * Método que envia la incidencia
	 * @param incidence
	 * @return
	 */
	public boolean enviadaIncidencia(Incidence incidence) {
		if (incidence.getAgent() != null) {
			// Asociamos a la incidencia una persona de gestion de incidencias aleatoria
			incidence.setIncidentManagementStaff(incidentManagementStaffService.obtenerUnOperadorAleatoriamente());

			//Si la incidencia no la envia un sensor se almacena en la BD
			if( ! incidence.getAgent().getTipo().equals("Sensor") )
				saveIncidence(incidence);
			
			//Enviamos la incidencia a Apache Kafka
			sendIncidence.sendIncidence(generarJSON(incidence));
			
			return true;
		}
		return false;
		
	}
	
	/**
	 * Método que genera un objeto JSON con la informacion de la incidencia
	 * @param incidence
	 * @return
	 */
	public String generarJSON(Incidence incidence) {
		JSONObject json = new JSONObject();

		try {
			json.put("identifier", incidence.getId());
			json.put("login", incidence.getAgent().getIdentificador());
			json.put("password", incidence.getAgent().getPassword());
			json.put("kind", incidence.getAgent().getTipo());
			json.put("name", incidence.getNombre());
			json.put("description", incidence.getDescripcion());
			json.put("location", incidence.getLocalizacion());
			json.put("tags", incidence.getTags());
			json.put("properties", incidence.getProperties());
			json.put("status", incidence.getEstado());
			json.put("incidentManagementStaffIdentifier", incidence.getIncidentManagementStaff().getIdentificador());
			json.put("expiration", incidence.getFechaCaducidad());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json.toString();
	}
}
