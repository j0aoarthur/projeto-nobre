package com.nobre.people.DTOs;

import java.time.LocalDate;

import com.nobre.people.entities.Person;


public record PersonDTO(String name, String email, String phone, LocalDate birthDate) {

    public PersonDTO(Person person) {
        this(person.getName(), person.getEmail(), person.getPhone(), person.getBirthDate());
    }
    
}
