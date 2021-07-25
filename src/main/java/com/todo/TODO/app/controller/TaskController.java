package com.todo.TODO.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo.TODO.app.model.Task;
import com.todo.TODO.app.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public String tasks(Model model) {

		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		model.addAttribute("task", new Task());
		model.addAttribute("isAdd", true);

		return "todo";
	}

	@PostMapping(value = "/save")
	public String save(@ModelAttribute Task task, RedirectAttributes redirectAttributes, Model model) {
		Task dbTask = taskService.save(task);
		if (dbTask != null) {
			redirectAttributes.addFlashAttribute("successmessage", "Task saved successfully.");
			return "redirect:/";
		} else {
			model.addAttribute("errormsg", "Task not saved.");
			model.addAttribute("task", task);
			return "todo";
		}
	}

	@GetMapping(value = "/getTask/{id}")
	public String getTask(@PathVariable Long id, Model model) {
		Task task = taskService.findById(id);
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		model.addAttribute("task", task);
		model.addAttribute("isAdd", false);
		return "todo";
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute Task task, RedirectAttributes redirectAttributes, Model model) {
		Task dbTask = taskService.update(task);
		if (dbTask != null) {
			redirectAttributes.addFlashAttribute("successmessage", "Task updated successfully.");
			return "redirect:/";
		} else {
			model.addAttribute("errormsg", "Task not updated.");
			model.addAttribute("task", task);
			return "todo";
		}
	}

	@GetMapping(value = "/deleteTask/{id}")
	public String deleteTask(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {

		taskService.delete(id);
		redirectAttributes.addFlashAttribute("successmessage", "Task deleted successfully.");
		return "redirect:/";
	}
}
