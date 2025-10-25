package br.edu.ifba.inf015.medHealthAPI.repositories;

import br.edu.ifba.inf015.medHealthAPI.models.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
