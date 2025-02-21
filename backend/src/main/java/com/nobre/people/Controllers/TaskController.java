package com.nobre.people.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobre.people.DTOs.TaskDTO;
import com.nobre.people.entities.Task;
import com.nobre.people.services.TaskService;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @PutMapping("/{idTask}")
    public Task updateTask(@RequestBody TaskDTO taskDTO, @PathVariable Integer idTask){
        return taskService.updateTask(taskDTO, idTask);
    }

    @DeleteMapping("/{idTask}")
    public void deleteTask(@PathVariable Integer idTask){
        taskService.deleteTask(idTask);
    }

    @PostMapping("/{idPerson}")
    public Task createTask(@RequestBody TaskDTO taskDTO, @PathVariable Integer idPerson) {
        return taskService.createTask(taskDTO, idPerson);
    }
}
