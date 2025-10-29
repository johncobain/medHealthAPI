package br.edu.ifba.inf015.medHealthAPI.services;

import br.edu.ifba.inf015.medHealthAPI.dtos.PatientDto;
import br.edu.ifba.inf015.medHealthAPI.dtos.PatientFormDto;
import br.edu.ifba.inf015.medHealthAPI.exceptions.EntityNotFoundException;
import br.edu.ifba.inf015.medHealthAPI.exceptions.UniqueAttributeAlreadyRegisteredException;
import br.edu.ifba.inf015.medHealthAPI.models.entities.Patient;
import br.edu.ifba.inf015.medHealthAPI.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Page<PatientDto> getAll(Pageable pageable) {
        return this.patientRepository.findByStatus(pageable, "ACTIVE").map(PatientDto::new);
    }

    public PatientDto getOne(Long id){
        Patient patient = this.patientRepository.findByIdAndStatus(id, "ACTIVE");
        if (patient == null) throw new EntityNotFoundException(Patient.class.getSimpleName(), id);
        return PatientDto.fromEntity(patient);
    }

    @Transactional
    public PatientDto save(PatientFormDto patient){
        if (this.patientRepository.existsByCpf(patient.cpf())){
            throw new UniqueAttributeAlreadyRegisteredException(Patient.class.getSimpleName(), "CPF");
        }
        return PatientDto.fromEntity(this.patientRepository.save(new Patient(patient)));
    }
}
