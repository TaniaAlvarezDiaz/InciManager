package cucumber.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.InciManagerApplication;
import model.Agent;
import services.AgentService;

@ContextConfiguration(classes=InciManagerApplication.class, loader=SpringApplicationContextLoader.class)
@SpringBootTest
public class LoginStep {

	private Agent agent;
	
	@Autowired
	private AgentService agentService;
	
	@Given("^el agente con username \"([^\"]*)\" y password \"([^\"]*)\" y tipo \"([^\"]*)\"$")
	public void el_agente_con_username_y_password_y_kind(String username, String password, String kind) throws Throwable {
		agent = agentService.find(username, password, kind);
	}
	
	@When("^rellene el formulario y pulse el boton Enviar$")
	public void el_agente_rellena_formulario_y_pulsa_enviar() throws Throwable {
		
	}

	@Then("^inicia sesion y se muestra la pantalla informativa$")
	public void el_agente_inicia_sesion_correctamente() throws Throwable {
		Assert.notNull(agent, "No se encontro al agente");
	}

}
