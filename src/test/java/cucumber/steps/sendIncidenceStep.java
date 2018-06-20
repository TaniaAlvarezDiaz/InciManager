package cucumber.steps;

import static org.junit.Assert.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.InciManagerApplication;


//@ContextConfiguration(classes=InciManagerApplication.class, loader=SpringApplicationContextLoader.class)
@SpringBootTest
public class sendIncidenceStep {

	@Given("^una incidencia con nombre \"([^\"]*)\", descripcion \"([^\"]*)\", etiquetas $")
	public void los_siguientes_datos_de_la_incidencia_name_description(String name, String description, String etiquetas, String propiedades) throws Throwable {	    
	    
	}

	@When("^el agente envía la incidencia$")
	public void el_agente_envía_la_incidencia() throws Throwable {
	   
	}

	@Then("^la incidencia es enviada correctamente$")
	public void la_incidencia_es_enviada_correctamente() throws Throwable {
	
	}
}
