package com.nobre.people.entities;

import java.time.LocalDateTime;

import com.nobre.people.DTOs.TaskDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Task(TaskDTO taskDTO) {
        this.setDescription(taskDTO.description());
        this.setTime(LocalDateTime.now());
    }

    public void updateTask(TaskDTO taskDTO) {
        this.setDescription(taskDTO.description());
    }
    
}
