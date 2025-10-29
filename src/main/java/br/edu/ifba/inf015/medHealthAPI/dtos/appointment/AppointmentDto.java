package br.edu.ifba.inf015.medHealthAPI.dtos.appointment;

import br.edu.ifba.inf015.medHealthAPI.dtos.doctor.DoctorDto;
import br.edu.ifba.inf015.medHealthAPI.dtos.patient.PatientDto;
import br.edu.ifba.inf015.medHealthAPI.models.entities.Appointment;

import java.sql.Timestamp;

public record AppointmentDto (
    Long id,
    Timestamp date,
    DoctorDto doctor,
    PatientDto patient,
    String status
){
    public AppointmentDto(Appointment appointment){
        this(appointment.getId(), appointment.getDate(), DoctorDto.fromEntity(appointment.getDoctor()), PatientDto.fromEntity(appointment.getPatient()), appointment.getStatus());
    }

    public static AppointmentDto fromEntity(Appointment appointment){
        return new AppointmentDto(appointment);
    }
}
