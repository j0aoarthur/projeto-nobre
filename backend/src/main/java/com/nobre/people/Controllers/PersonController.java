package com.nobre.people.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobre.people.DTOs.PersonDTO;
import com.nobre.people.entities.Person;
import com.nobre.people.services.PersonService;

@RestController
@RequestMapping("/person")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> listPerson() {
        return personService.listPeople();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Integer id) {
        return personService.getPersonById(id);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@RequestBody PersonDTO personDTO, @PathVariable Integer id){
        return personService.updatePerson(personDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }
}
