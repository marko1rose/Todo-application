package com.todo.TODO.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.todo.TODO.app.model.Task;
import com.todo.TODO.app.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/tasks")
	public String tasks(Model model) {

		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		model.addAttribute("task", new Task());
		model.addAttribute("isAdd", true);

		return "todo";
	}
}
