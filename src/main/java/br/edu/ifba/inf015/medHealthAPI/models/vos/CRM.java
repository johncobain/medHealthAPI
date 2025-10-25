package br.edu.ifba.inf015.medHealthAPI.models.vos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class CRM {
    @Column(name = "crm")
    private String crm;

    public CRM() {}

    public CRM(String crm) {
        this.crm = crm;
    }

    @JsonValue
    public String getCrm() {
        return crm;
    }

    @JsonCreator
    public static CRM fromString(String crm) {
        return new CRM(crm);
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CRM that)) return false;
        return Objects.equals(crm, that.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm);
    }

    @Override
    public String toString() {
        return crm;
    }
}
