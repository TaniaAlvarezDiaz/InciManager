package inciManager;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.Agent;
import model.Incidence;
import model.Incidence.Estado;
import model.IncidentManagementStaff;
import model.Property;

public class InciManagerTest {
	
	@Test
	public void crearAgent() {
		Agent a = new Agent("Jorge", "", "jorge@gmail.com", "09854758P", "Person");
		
		String resultado = "Agent [id=" + null + ", nombre=" + "Jorge" + ", localizacion=" + " " + ", email=" + "jorge@gmail.com" + ", identificador=" + "09854758P"
				+ ", tipo=" + "Person" + "]";
		
		assertEquals(resultado, a.toString());
	}
	
	@Test
	public void crearIncidencia() {
		//Creamos el agente
		Agent a = new Agent("Jorge", "", "jorge@gmail.com", "09854758P", "Person");
		
		//Creamos el incidentManagementStaff
		IncidentManagementStaff ims = new IncidentManagementStaff("Sofia", "sofia@gmail.com", "74851236S", "1234");
		
		//Creamos las etiquetas
		Set<String> etiquetas = new HashSet<String>();
		etiquetas.add("fuego");
		etiquetas.add("urgente");
		
		//Creamos las propiedades
		Set<Property> propiedades = new HashSet<Property>();
		propiedades.add(new Property("temperatura", "50"));
		
		//Creamos la incidencia asignandole al IMS creado
		Incidence i = new Incidence("Fuego", "Fuego en Uría", Estado.ABIERTA, a, etiquetas, propiedades, "");
		i.setIncidentManagementStaff(ims);
		
		String resultado = "Incidence [id=" + null + ", nombre=" + "Fuego" + ", descripcion=" + "Fuego en Uría" + ", estado=" + Estado.ABIERTA
				+ ", agent=" + a.toString() + ", localizacion=" + a.getLocation().toString() + ", tags=" + i.getTags().toString()
				+ ", properties=" + i.getProperties().toString() + ", incidentManagementStaff=" + ims.toString()
				+ ", comments=" + null + ", fechaCaducidad=" + "" + ", peligrosa=" + false + "]";

		assertEquals(resultado, i.toString());
	}

}
