package com.Magistances.chatbot.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Dates")
public class Dates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_date")
    private Long idDate;
    @Column(name = "service_date")
    private String serviceDate;
    @Column(name = "payment_status_date")
    private String paymentStatusDate;
    @Column(name = "day_of_date")
    private LocalDate dayOfDate;
    @Column(name = "hour_of_date")
    private LocalTime hourOfDate;
    @Column(name = "creation_date")
    private String creationDate;

    @ManyToOne
    @JoinColumn(name = "user_dates")
    private User user_fk;
}
