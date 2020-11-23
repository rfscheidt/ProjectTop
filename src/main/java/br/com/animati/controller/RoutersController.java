package br.com.animati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.animati.service.PacienteService;

@Controller
public class RoutersController {
	
	@Autowired
	private PacienteService pacienteService; 
	
	@GetMapping("/paciente/index")
	public String pacienteIndex(Model model) {
		model.addAttribute("pacietes", pacienteService.list());
		model.addAttribute("foka", "fokaaaaaaa");
		return "paciente/index";
	}

}
