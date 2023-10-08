package com.parkme.app.service.imp;

import com.parkme.app.model.entity.Person;
import com.parkme.app.model.entity.Vehicle;
import com.parkme.app.model.view.PersonDto;

import java.util.List;

public interface PersonService  {

    public PersonDto createPerson(Person persona);
    public List<PersonDto> listPersons();

    public PersonDto getPersonById(Long id);

    public PersonDto editPersonById(Long id, Person persona);

    public void  deletePersonById(Long id);

    PersonDto addVehicle(Long id, Vehicle vehicle);
}
