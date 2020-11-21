package br.com.animati.service;

import java.util.List;
import java.util.Optional;

import br.com.animati.entity.Paciente;

public interface PacienteService {
	
	public void add(Paciente p);
	
	public List<Paciente> list();
	
	public void delete(Paciente paciente);
	
	public Optional<Paciente> findById(long idPaciente);
	
}
