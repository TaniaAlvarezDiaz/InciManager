package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import util.ReaderCSV;

@Controller
public class HomeController {

	@RequestMapping("/login")
	public String login(Model model) {
		// Enviamos a la vista los tipos de agente, sacados del fichero csv
		model.addAttribute("kinds", new ReaderCSV().getKinds());
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
