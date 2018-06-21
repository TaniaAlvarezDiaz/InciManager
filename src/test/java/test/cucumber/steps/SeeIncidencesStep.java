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

public class SeeIncidencesStep {

	private WebDriver driver = new HtmlUnitDriver(); //para usar selenium
	
	@Dado("^el agente en la pantalla informativa de la aplicacion$")
	public void agente_en_pantalla_informativa() throws Throwable {
		List<WebElement> r = driver.findElements(By.xpath("//*[text() = 'Incidencia enviada correctamente']"));
		assertEquals(1, r.size());
	}

	@Cuando("^haga click en el boton \"Incidencias enviadas\" de la barra de navegacion$")
	public void pulse_incidencias_enviadas() throws Throwable {
		driver.get("http://localhost:8091/index");
	    driver.findElement(By.name("incidencesSent")).click();
	}

	@Entonces("^se mostrara una tabla con las incidencias enviadas por dicho agente$")
	public void aparece_tabla_con_incidencias() throws Throwable {
		List<WebElement> r = driver.findElements(By.xpath("//*[text() = 'Incidencias enviadas']"));
		assertEquals(1, r.size());
	}
}
