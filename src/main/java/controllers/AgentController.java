package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import services.IncidenceService;

@Controller
public class AgentController {
	
	@Autowired
	private IncidenceService incidenceService;
	
	@RequestMapping(value = "/incidence/sent")
	public String getIncidencesSent(Model model) {
		// auth almacena toda la informacion del usuario autenticado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		// Obtenemos las incidencias enviadas por el agente que esta en sesion
		model.addAttribute("incidences",  incidenceService.findByAgent(username));
		return "incidence/sent";
	}
}
