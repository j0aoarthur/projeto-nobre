package com.nobre.people.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobre.people.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    
}
