package com.nobre.people.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobre.people.DTOs.TaskDTO;
import com.nobre.people.repositories.TaskRepository;
import com.nobre.people.entities.Person;
import com.nobre.people.entities.Task;
import com.nobre.people.repositories.PersonRepository;

@Service
public class TaskService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired 
    private TaskRepository taskRepository;

    public Task createTask(TaskDTO taskDTO, Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();

            Task task = new Task(taskDTO);
            task.setPerson(person);
            taskRepository.save(task);

            return task;
        }

        throw new RuntimeException("Não foi encontrada a pessoa desejada");
    }

    public Task updateTask(TaskDTO taskDTO, Integer id) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.updateTask(taskDTO);

            taskRepository.save(task);
            return task;
        }
        throw new RuntimeException("Não foi encontrada a pessoa desejada");
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}
