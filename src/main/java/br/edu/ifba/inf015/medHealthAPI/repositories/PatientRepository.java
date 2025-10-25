package br.edu.ifba.inf015.medHealthAPI.repositories;

import br.edu.ifba.inf015.medHealthAPI.models.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
