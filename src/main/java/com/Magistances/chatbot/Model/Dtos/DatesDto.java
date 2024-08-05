package com.Magistances.chatbot.Model.Dtos;

import com.Magistances.chatbot.Model.Entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public record DatesDto(
         Long idDate,
         @NotBlank
         String serviceDate,
         @NotBlank
         String paymentStatusDate,
         @NotEmpty
         LocalDate dayOfDate,
         @NotEmpty
         LocalTime hourOfDate,
         @NotBlank
         String creationDate,

         @NotNull
         Long user_fk


) {
}
