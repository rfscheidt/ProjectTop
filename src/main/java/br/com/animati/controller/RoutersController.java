package br.com.animati.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutersController {
	
	@GetMapping("/paciente/index")
	public String pacienteIndex() {
	    return "/paciente/index";
	}

}
