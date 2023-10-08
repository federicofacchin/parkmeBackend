package com.parkme.app.controller;

import com.parkme.app.model.entity.Person;
import com.parkme.app.model.entity.Vehicle;
import com.parkme.app.model.view.PersonDto;
import com.parkme.app.service.imp.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/listar")
    public ResponseEntity<List<PersonDto>> getPersons(){
        return new ResponseEntity<>(personService.listPersons(), HttpStatus.OK);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<PersonDto> registerPerson(@RequestBody Person person){
        return new ResponseEntity<>(personService.createPerson(person),HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PersonDto> updatePersonById(@PathVariable Long id, @RequestBody Person person){
        return new ResponseEntity<>(personService.editPersonById(id, person), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long id){
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/cargarVehiculo/{id}")
    public ResponseEntity<PersonDto> assignVehicleToPerson(@PathVariable Long id, @RequestBody Vehicle vehicle){
        return new ResponseEntity<>(personService.addVehicle(id,vehicle), HttpStatus.OK);
    }


}
