package br.com.animati;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.animati.entity.Atendimento;
import br.com.animati.entity.Paciente;
import br.com.animati.service.AtendimentoService;
import br.com.animati.service.PacienteService;

@SpringBootTest
public class AtendimentoTests {
	
	@Autowired
	private AtendimentoService atendimentoService;
	
	@Autowired
	private PacienteService pacienteService;
	
	private void initPacientes() {
		Paciente p1 = new Paciente();
		p1.setNome("Andre Jobim");
		p1.setCpf("0020020002-22");
		
		pacienteService.add(p1);
		
		Paciente p2 = new Paciente();
		p2.setNome("Rafael Scheidt");
		p2.setCpf("0010010001-12");
		
		pacienteService.add(p2);
	}
	
	private void initAtendimentos() {
		initPacientes();
		
		Atendimento ate1 = new Atendimento();
		ate1.setNomeProcedimento("RX MAO DIREITA");
		ate1.setDataHora("22/11/2020 16:00:00");
		ate1.setPaciente(pacienteService.findById(1).get());
		atendimentoService.add(ate1);
		
		Atendimento ate2 = new Atendimento();
		ate2.setNomeProcedimento("RX MAO ESQUERDA");
		ate2.setDataHora("22/11/2020 16:10:00");
		ate2.setPaciente(pacienteService.findById(1).get());
		atendimentoService.add(ate2);
	}
	
	@Test
	public void listTest() {
		initAtendimentos();
		
		List<Atendimento> list = atendimentoService.list();
		for (Atendimento atendimento : list) {
			System.out.println(atendimento.getNomeProcedimento());
		}
	}

}
