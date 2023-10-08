package com.parkme.app.model.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Document(collection = "persons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Person {
    //notas deberia haber una lista de chats que contengan mensajes o no hace falta persistirlo
    //tiene que tener un historial de reservas

    //hace falta una entidad reserva que una a la conchera con el usuario y que tenga dos atributos con el rango horario de la reserva
    //despues cuando va a reservar quiero tener un rango horario por dia y tipo que se vaya acortando a medida que vayan haciendo reservas
    //private List<Cochera> cocheras;

    @MongoId
    private Long id ;

    private String name;

    private String surname;

    private String email;

    private String phone;

    private Vehicle vehicle;

    @DateTimeFormat
    private LocalDate birthDate;

    //private String password;
//    private List<ParkingHistory> parkingHistory;
//    private List<ParkingLot> parkingSlots;



    // la persona deberia tener una lista de cocheras, un auto , email, nombre y apellido , direccion

}
