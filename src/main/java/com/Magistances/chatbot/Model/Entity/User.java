package com.Magistances.chatbot.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_user")
    private Long idUser;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "phone_user")
    private String phoneUser;
    @Column(name = "direccion_user")
    private String DireccionUser;
}
