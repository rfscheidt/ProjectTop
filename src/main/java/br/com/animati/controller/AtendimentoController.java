package br.com.animati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.animati.entity.Atendimento;
import br.com.animati.service.AtendimentoService;

@RestController
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService atendimentoService;
	
	@RequestMapping("/atendimentos")
	public List<Atendimento> list() {
		return atendimentoService.list();
	}
	
	@PostMapping("/atendimentos")
	public void save(@RequestBody Atendimento p) {
		//p.setPaciente(pacienteService.findById(p.getPaciente().getIdPaciente()).get());
		atendimentoService.add(p);
	}

}