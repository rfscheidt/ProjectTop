package br.com.animati.service;

import java.util.List;
import java.util.Optional;

import br.com.animati.entity.Atendimento;

public interface AtendimentoService {
	
	public void add(Atendimento atendimento);
	
	public List<Atendimento> list();
	
	public void delete(Atendimento atendimento);
	
	public Optional<Atendimento> findById(long idAtendimento);

}
