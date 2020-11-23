package br.com.animati.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.animati.entity.Paciente;
import br.com.animati.service.PacienteService;

@RestController
public class PacienteController {
	//https://www.treinaweb.com.br/blog/criando-uma-api-rest-com-o-spring-boot/
	@Autowired
	private PacienteService pacienteService;
	
	@RequestMapping("/pacientes")
	public List<Paciente> list() {
		return pacienteService.list();
	}
	
	@PostMapping("/pacientes")
	public void save(@RequestBody Paciente p) {
		pacienteService.add(p);
	}
	
	@RequestMapping("/pacientes/{idPaciente}")
	public Paciente findById(@PathVariable long idPaciente) {
		return pacienteService.findById(idPaciente).get();
	}
	
	@DeleteMapping("/pacientes/{idPaciente}")
	public void delete(@PathVariable long idPaciente) {
		Paciente paciente = pacienteService.findById(idPaciente).get();
		pacienteService.delete(paciente);
	}
	
	@PutMapping("/pacientes/{idPaciente}")
	public void update(@PathVariable long idPaciente, @RequestBody Paciente newPaciente) {
		Optional<Paciente> oldPaciente = pacienteService.findById(idPaciente);
		if (oldPaciente.isPresent()) {
			Paciente paciente = oldPaciente.get();
			paciente.setNome(newPaciente.getNome());
			
			pacienteService.add(paciente);
		}
	}

}
