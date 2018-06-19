package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Agent;
import services.AgentService;
import util.ReaderCSV;

@Controller
public class HomeController {

	@Autowired
	private AgentService agentService;
	
	@RequestMapping("/")
	public String mostrarLogin(Model model) {
		// Enviamos a la vista los tipos de agente, sacados del fichero csv
		model.addAttribute("kinds", new ReaderCSV().getKinds());
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		// Enviamos a la vista los tipos de agente, sacados del fichero csv
		model.addAttribute("kinds", new ReaderCSV().getKinds());
		return "login";
	}
	
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String kind) {
    	Agent a = agentService.findByIdentificador(username);
    	if (a == null)
    		return "login";
    	if (a.getPassword().equals(password) && a.getTipo().equals(kind))
    			return "index";
    	return "login";
	}
	
	@RequestMapping("/home")
	public String index(Model model, @RequestParam(required = false) boolean enviadaCorrectamente) {
		model.addAttribute("enviadaCorrectamente", enviadaCorrectamente);
		return "index";
	}

	@RequestMapping("/managerError")
	public String error(Model model, @RequestParam(required = false) String mensajeError) {
		model.addAttribute("mensajeError", mensajeError);
		return "error";
	}
}
