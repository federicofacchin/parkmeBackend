package com.parkme.app.model.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "parkingLots")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingLot {
    private static final Double additionalCharge = 1.55;
    //tambien habria que ver el tema de cuando se reserva un horario
    //pondria una lista de mensajes y puntuaciones

    //cada cochera tendria reviews y comentarios
    @MongoId
    private Long id ;
    private Double pricePerHour;
    private int streetNumber;
    private boolean isAvailable;
    private String streetName;
    private boolean haveRoof;
    private String neighborhood;
    private String locality;
    private String aditionalNotes;
    private Person owner;
    private List<TimeRange> avaliableHours;
}
