package br.edu.ifba.inf015.medHealthAPI.dtos;

import br.edu.ifba.inf015.medHealthAPI.models.entities.Doctor;
import br.edu.ifba.inf015.medHealthAPI.models.enums.Specialty;

public record DoctorDto(
        Long id,
        String name,
        String email,
        String phone,
        String crm,
        AddressDto address,
        Specialty specialty,
        String status
) {
    public DoctorDto(Doctor doctor){
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getCrm(),
                AddressDto.fromEntity(doctor.getAddress()),
                doctor.getSpecialty(),
                doctor.getStatus()
        );
    }

    public static DoctorDto fromEntity(Doctor doctor){
        return new DoctorDto(doctor);
    }
}
