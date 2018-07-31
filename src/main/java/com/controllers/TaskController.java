package com.controllers;


import com.services.TaskService;
import com.model.CustomResponseObject;
import com.model.Task;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")

public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping
    public CustomResponseObject<List<Task>> getTasks() throws Exception {

        List<Task> tasks = taskService.findAllTasks();
        CustomResponseObject obj = new CustomResponseObject();
        obj.setData(tasks);
        obj.setStatusCode(200);

        return obj;

    }

    @GetMapping("/{id}")
    public CustomResponseObject<Task> findTaskById(@PathVariable("id") long id) throws Exception {
        Task task = taskService.findTaskById(id);

        CustomResponseObject obj = new CustomResponseObject();
        obj.setData(task);
        obj.setStatusCode(200);

        return obj;

    }

    @PostMapping
    public CustomResponseObject<Task> createTask(@Valid @RequestBody Task task) throws Exception {

        Task u = taskService.createTask(task);

        CustomResponseObject obj = new CustomResponseObject();
        obj.setData(task);
        obj.setStatusCode(200);

        return obj;

    }
}
