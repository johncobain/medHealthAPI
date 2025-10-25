package br.edu.ifba.inf015.medHealthAPI.models.vos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class CPF {
    private String cpf;

    public CPF() {}

    public CPF(String cpf) {
        this.cpf = cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @JsonValue
    public String getCpf() {
        return cpf;
    }

    @JsonCreator
    public static CPF fromString(String cpf) {
        return new CPF(cpf);
    }

    @Override
    public String toString() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPF that)) return false;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
