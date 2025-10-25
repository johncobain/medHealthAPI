package br.edu.ifba.inf015.medHealthAPI.controllers;

import br.edu.ifba.inf015.medHealthAPI.dtos.PatientDto;
import br.edu.ifba.inf015.medHealthAPI.dtos.PatientFormDto;
import br.edu.ifba.inf015.medHealthAPI.models.entities.Patient;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @PostMapping
    public PatientDto create(@Valid @RequestBody PatientFormDto patientFormDto) {
        Patient patient = new Patient(patientFormDto);
        PatientDto test = PatientDto.fromEntity(patient);

        return test;
    }
}
