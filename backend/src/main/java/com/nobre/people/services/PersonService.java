package com.nobre.people.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobre.people.DTOs.PersonDTO;
import com.nobre.people.entities.Person;
import com.nobre.people.repositories.PersonRepository;

@Service
public class PersonService {
    

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(PersonDTO personDTO) {
        Person person = new Person(personDTO);
        personRepository.save(person);

        return person;
    }

    public Person updatePerson(PersonDTO personDTO, Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            personRepository.save(person);
            return person;
        }
        throw new RuntimeException("Não foi encontrada a pessoa desejada");
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    public List<Person> listPeople() {
        return personRepository.findAll();
    }

    public Person getPersonById(Integer id){
        Optional<Person> personOptional = personRepository.findById(id);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            return person;
        }
        throw new RuntimeException("Não foi encontrada a pessoa desejada"); 
    }
}
