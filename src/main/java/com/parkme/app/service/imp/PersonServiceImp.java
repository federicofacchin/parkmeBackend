package com.parkme.app.service.imp;

import com.parkme.app.exception.EntityNotFoundException;
import com.parkme.app.exception.PersonAlreadyExistsException;
import com.parkme.app.model.entity.Person;
import com.parkme.app.model.entity.Vehicle;
import com.parkme.app.model.view.PersonDto;
import com.parkme.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonDto createPerson(Person person) {
        validatePersonData(person);
        Person personCreated  = personRepository.save(person);
        return PersonDto.builder().phone(personCreated.getPhone()).name(personCreated.getName()).surname(personCreated.getSurname()).build();
    }

    private void validatePersonData(Person person) {
        Optional<Person> personFound = personRepository.findById(person.getId());
        if(personFound.isPresent()){
            throw new PersonAlreadyExistsException("Che ya existe el tipo con el id " + person.getId());
        }
    }

    @Override
    public List<PersonDto> listPersons() {
        return personRepository.findAll().stream().map(person -> generatePersonDto(person)
                        ).toList();
    }

    @Override
    public PersonDto getPersonById(Long id) {
        Person person = validateIdAndGetPerson(id);
        return generatePersonDto(person);
    }

    private Person validateIdAndGetPerson(Long id){
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe la persona que buscas"));
    }

    @Override
    public PersonDto editPersonById(Long id, Person person) {
        Person personaToGetEdited =  validateIdAndGetPerson(id);
        personRepository.save(editPersonValues(personaToGetEdited,person));
        return generatePersonDto(person);
    }

    private Person editPersonValues(Person personaToGetEdited,Person person) {
        personaToGetEdited.setSurname(person.getSurname());
        personaToGetEdited.setEmail(person.getEmail());
        personaToGetEdited.setVehicle(person.getVehicle());
        personaToGetEdited.setName(person.getName());
        personaToGetEdited.setBirthDate(person.getBirthDate());
        //personaToGetEdited.setCocheras(persona.getCocheras());
        return personaToGetEdited;
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.delete(validateIdAndGetPerson(id));
    }

    @Override
    public PersonDto addVehicle(Long id, Vehicle vehicle) {
        Person person = validateIdAndGetPerson(id);
        person.setVehicle(vehicle);
        personRepository.save(person);
        return generatePersonDto(person);
    }

    private PersonDto generatePersonDto(Person person) {
        return PersonDto.builder().name(person.getName()).vehicle(person.getVehicle()).phone(person.getPhone()).surname(person.getSurname())
                .build();
    }
}
