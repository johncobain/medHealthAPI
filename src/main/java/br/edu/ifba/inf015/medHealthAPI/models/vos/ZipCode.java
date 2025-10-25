package br.edu.ifba.inf015.medHealthAPI.models.vos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Embeddable
public class ZipCode {
    @Column(name = "zip_code")
    private String zipCode;

    protected ZipCode() { }

    public ZipCode(String zipCode) {
        this.zipCode = normalize(zipCode);
    }

    @JsonValue
    public String getZipCode() {
        return zipCode;
    }

    @JsonCreator
    public static ZipCode fromString(String value) {
        return new ZipCode(value);
    }

    public void setZipCode(String zipCode) {
        this.zipCode = normalize(zipCode);
    }

    private static String normalize(String zipCode) {
        if (zipCode == null) return null;
        String digits = zipCode.replaceAll("\\D", "");
        if (digits.length() != 8) return zipCode;
        return digits.substring(0, 5) + "-" + digits.substring(5);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZipCode that)) return false;
        return Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode);
    }

    @Override
    public String toString() {
        return zipCode;
    }
}
