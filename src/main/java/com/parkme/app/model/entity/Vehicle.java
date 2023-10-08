package com.parkme.app.model.entity;

import com.parkme.app.model.enums.VehicleType;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "vehicles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @MongoId
    private Long id ;
    private String patentPlate;

    private String vehicleBrand;

    private String model;

    private VehicleType vehicleType;

    private Person owner;

}
