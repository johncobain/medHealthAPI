package br.edu.ifba.inf015.medHealthAPI.dtos;

import br.edu.ifba.inf015.medHealthAPI.models.entities.Patient;

public record PatientDto(
        Long id,
        String name,
        String email,
        String phone,
        String cpf,
        AddressDto address,
        String status
) {
    public PatientDto(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getCpf(), AddressDto.fromEntity(patient.getAddress()), patient.getStatus());
    }

    public static PatientDto fromEntity(Patient patient){
        return new PatientDto(patient);
    }
}
