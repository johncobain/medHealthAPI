package br.edu.ifba.inf015.medHealthAPI.dtos.user;

import br.edu.ifba.inf015.medHealthAPI.models.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserFormDto (
        @NotBlank(message = "Username is required")
        String username,
        @NotBlank(message = "Password is required")
        String password
){
   public UserFormDto(User user) {
       this(user.getUsername(), user.getPassword());
   }
}
