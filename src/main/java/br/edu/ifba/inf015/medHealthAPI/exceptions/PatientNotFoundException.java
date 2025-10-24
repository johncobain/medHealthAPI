package br.edu.ifba.inf015.medHealthAPI.exceptions;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }

    public PatientNotFoundException(Long id) {
        super("Patient not found with id: " + id);
    }
}
