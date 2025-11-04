package br.edu.ifba.inf015.medHealthAPI.repositories;

import br.edu.ifba.inf015.medHealthAPI.models.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findByStatus(Pageable pageable, String status);
    Page<Doctor> findByNameContainingAndStatus(Pageable pageable, String name, String status);
    Doctor findByIdAndStatus(Long id, String status);
    Doctor findByCrmAndStatus(String crm, String status);
    Doctor findByEmailAndStatus(String email, String status);

    boolean existsByCrm(String crm);
}
