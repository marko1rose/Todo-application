package com.todo.TODO.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.TODO.app.model.Task;
import com.todo.TODO.app.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> getAllTasks() {

		return taskRepository.findAll();
	}

}
