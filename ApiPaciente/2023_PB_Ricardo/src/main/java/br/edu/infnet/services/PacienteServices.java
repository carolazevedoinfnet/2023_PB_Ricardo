package br.edu.infnet.services;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.exceptions.ResourceNotFoundException;
import br.edu.infnet.model.Paciente;
import br.edu.infnet.repositories.PacienteRepository;

@Service
public class PacienteServices {
	
	private Logger logger = Logger.getLogger(PacienteServices.class.getName());

	
	@Autowired
	PacienteRepository repository;

	public List<Paciente> findAll() {

		logger.info("Buscar a lista de pacientes");

		return repository.findAll();
	}

	public Paciente findById(Long id) {
		
		logger.info("Buscar um paciente");
		
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado paciente com este ID"));
	}
	
	public Paciente create(Paciente paciente) {

		logger.info("Criar novo paciente!");
		
		return repository.save(paciente);
	}
	
	public Paciente update(Paciente paciente) {
		
		logger.info("Atualizar paciente");
		
		var entity = repository.findById(paciente.getId())
			.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado paciente com este ID"));

		entity.setNome(paciente.getNome());
		entity.setSobrenome(paciente.getSobrenome());
		entity.setNascimento(paciente.getNascimento());
		entity.setMae(paciente.getMae());
		entity.setPai(paciente.getPai());
		entity.setSexo(paciente.getSexo());
		entity.setCpf(paciente.getCpf());
		entity.setEmail(paciente.getEmail());
		entity.setTelefone(paciente.getTelefone());
		entity.setDtAtualizacao(paciente.getDtAtualizacao());
		
		return repository.save(paciente);
	}
	
	public void delete(Long id) {
		
		logger.info("Apagar um paciente");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado paciente com este ID"));
		repository.delete(entity);
	}
}