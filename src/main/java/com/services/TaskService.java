package com.services;

import com.model.Task;
import com.model.User;
import com.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;


    public List<Task> findAllTasks()throws Exception {

        List<Task> tasks;

        try {
            tasks = (List<Task>) taskRepository.findAll();
        } catch(Exception e){
            throw e;
        }

        return tasks;

    }

    public Task findTaskById(long id) throws Exception{

        Task u;

        try {
            u = taskRepository.findOne(id);
        } catch(Exception e){
            throw e;
        }

        return u;
    }

    public Task createTask(Task task) throws Exception {

        try {
            taskRepository.save(task);
            Task u = taskRepository.findByDate(task.getCreatedAt());
            return u;

        } catch (Exception e){
            throw e;
        }

    }

}
