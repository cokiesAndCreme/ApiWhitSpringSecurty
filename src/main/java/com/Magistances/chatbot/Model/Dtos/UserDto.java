package com.Magistances.chatbot.Model.Dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
public record UserDto(
         Long idUser,
         @NotEmpty
         @Size(max = 120)
         String nameUser,

         @NotBlank
         @Size(min = 10, max = 12)
         String phoneUser,

         @Size( max = 300)
         String DireccionUser) {
}
