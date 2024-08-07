package com.Magistances.chatbot.Model.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DatesDtoFindByIdUser(

                                   @NotBlank
                                   String serviceDate,
                                   @NotBlank
                                   String paymentStatusDate,
                                   @NotEmpty
                                   LocalDate dayOfDate,
                                   @NotEmpty
                                   LocalTime hourOfDate)

{
}
