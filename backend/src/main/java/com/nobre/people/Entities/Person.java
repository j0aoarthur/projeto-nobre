package com.nobre.people.entities;
import java.time.LocalDate;
import java.util.List;

import com.nobre.people.DTOs.PersonDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "people")
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "person")
    private List<Task> listTask;

    public Person(PersonDTO personDTO) {
        this.setName(personDTO.name());
        this.setEmail(personDTO.email());
        this.setBirthDate(personDTO.birthDate());
        this.setPhone(personDTO.phone());
    }
}