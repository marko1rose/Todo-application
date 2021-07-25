package com.todo.TODO.app.service;

import java.util.List;
import java.util.Optional;

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

	public Task save(Task task) {

		return taskRepository.save(task);
	}

	public Task findById(Long id) {

		Optional<Task> task = taskRepository.findById(id);

		if (task.isPresent()) {
			return task.get();
		} else {
			return null;
		}
	}

	public Task update(Task task) {
		return taskRepository.save(task);
	}

	public void delete(Long id) {
		taskRepository.deleteById(id);
	}

}
