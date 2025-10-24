package br.edu.ifba.inf015.medHealthAPI.exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message) {
        super(message);
    }

    public DoctorNotFoundException(Long id) {
        super("Doctor not found with id: " + id);
    }
}
