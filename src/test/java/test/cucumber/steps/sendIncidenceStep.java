package test.cucumber.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class SendIncidenceStep {

	private WebDriver driver = new HtmlUnitDriver(); //para usar selenium
	
	private String nombre;
	private String descripcion;
	private String etiquetas;
	private String propiedades;
	
	@Dado("^una incidencia con nombre \"([^\"]*)\"$")
	public void incidencia_con_nombre(String nombre) throws Throwable {
		this.nombre = nombre;
	}
	
	@Y("^descripcion \"([^\\\"]*)\"$")
	public void y_descripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Y("^etiquetas \"([^\\\"]*)\"$")
	public void y_etiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	@Y("^propiedades \"([^\\\"]*)\"$")
	public void y_propiedades(String propiedades) {
		this.propiedades = propiedades;
	}

	@Cuando("^rellene el formulario y haga click en el boton \"Enviar\"$")
	public void el_agente_rellena_formulario_y_pulsa_enviar() throws Throwable {
		//Hay que iniciar sesion, lo hacemos con pedro
		driver.get("http://localhost:8091/login");
		driver.findElement(By.name("username")).sendKeys("09847581T");					
	    driver.findElement(By.name("password")).sendKeys("123456789");
	    driver.findElement(By.name("login")).click();
	    
		//Vamos al formulario para enviar incidencia
		driver.get("http://localhost:8091/incidence/send");
		driver.findElement(By.name("name")).sendKeys(nombre);					
	    driver.findElement(By.name("description")).sendKeys(descripcion);
	    driver.findElement(By.name("tags")).sendKeys(etiquetas);
	    driver.findElement(By.name("properties")).sendKeys(propiedades);
	    driver.findElement(By.name("enviar")).click();
	}

	@Entonces("^se enviara la incidencia y aparece la pantalla informativa indicando que se ha enviado correctamente$")
	public void aparece_pantalla_informativa() throws Throwable {
		List<WebElement> r = driver.findElements(By.xpath("//*[text() = 'Incidencia enviada correctamente']"));
		assertEquals(1, r.size());
	}
}
