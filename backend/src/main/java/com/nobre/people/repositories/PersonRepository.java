package com.nobre.people.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobre.people.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    
}
