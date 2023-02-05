package br.edu.infnet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.model.Paciente;

public interface PacienteRepository extends JpaRepository <Paciente, Long>{

}
