package com.Magistances.chatbot.Model.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public record DatesDto(
         Long idDate,
         String serviceDate,
         @NotBlank
         String paymentStatusDate,
         @NotEmpty
         LocalDate dayOfdate,
         @NotEmpty
         LocalTime hourOfDate,
         @NotBlank
         String creationDate
) {
}
