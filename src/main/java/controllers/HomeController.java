package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String mostrarLogin(Model model) {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
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
