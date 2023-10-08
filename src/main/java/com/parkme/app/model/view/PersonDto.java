package com.parkme.app.model.view;


import com.parkme.app.model.entity.Vehicle;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDto {

    private String name;
    private String surname;
    private String phone;
    private Vehicle vehicle;
}
