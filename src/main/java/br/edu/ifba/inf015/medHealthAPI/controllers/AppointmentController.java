package br.edu.ifba.inf015.medHealthAPI.controllers;

import br.edu.ifba.inf015.medHealthAPI.dtos.AppointmentDto;
import br.edu.ifba.inf015.medHealthAPI.dtos.AppointmentFormDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @PostMapping
    public AppointmentDto create(@Valid @RequestBody AppointmentFormDto appointmentFormDto) {
        // TODO: implementar
        return null;
    }
}
