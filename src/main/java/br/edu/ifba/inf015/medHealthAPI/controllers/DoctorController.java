package br.edu.ifba.inf015.medHealthAPI.controllers;

import br.edu.ifba.inf015.medHealthAPI.dtos.doctor.DoctorDto;
import br.edu.ifba.inf015.medHealthAPI.dtos.doctor.DoctorFormDto;
import br.edu.ifba.inf015.medHealthAPI.models.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @PostMapping
    public DoctorDto create(@Valid @RequestBody DoctorFormDto doctorFormDto) {
        Doctor doctor = new Doctor(doctorFormDto);
        DoctorDto test = DoctorDto.fromEntity(doctor);

        return test;
    }
}
