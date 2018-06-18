package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Agent;
import model.Incidence;
import services.AgentService;
import services.IncidenceService;

@Controller
public class IncidenceController implements AddIncidence{

	@Autowired
	private IncidenceService incidenceService;
	
	@Autowired
	private AgentService agentService;

	@Override
	@RequestMapping(value = "/incidence/send")
	public String addIncidence(Model model) {
		return "incidence/send";
	}

	@Override
	@RequestMapping(value = "/incidence/send", method = RequestMethod.POST)
	public String addIncidence(@RequestParam String name,@RequestParam String description,@RequestParam String tags,@RequestParam String properties) {
		// auth almacena toda la informacion del usuario autenticado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		// Obtenemos toda la informacion del usuario autenticado para crear la incidencia
		Agent activeUser = agentService.findByIdentificador(username);
		
		// Se crea la incidencia con los campos del formulario web.
		Incidence incidence = incidenceService.createIncidence(name, description, tags, properties, activeUser);
		
		if (incidenceService.enviadaIncidencia(incidence))
			return "redirect:/index?enviadaCorrectamente=true";
		return "redirect:/managerError?mensajeError=Error al enviar la incidencia.";
	}
	
}
