package br.edu.ifba.inf015.medHealthAPI.dtos;

import br.edu.ifba.inf015.medHealthAPI.models.entities.Appointment;
import br.edu.ifba.inf015.medHealthAPI.models.entities.Doctor;
import br.edu.ifba.inf015.medHealthAPI.models.entities.Patient;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record AppointmentFormDto(
        @NotNull(message = "Date is required")
        @Schema(description = "Appointment date", example = "2025-10-25T16:50:42")
        Timestamp date,

        @NotNull(message = "Doctor ID is required")
        @Schema(description = "Doctor id", example = "1")
        Long doctorId,

        @NotNull(message = "Patient ID is required")
        @Schema(description = "Patient id", example = "1")
        Long patientId
) {
    public AppointmentFormDto(Appointment appointment) {
        this(
                appointment.getDate(),
                appointment.getDoctor().getId(),
                appointment.getPatient().getId());
    }
}
