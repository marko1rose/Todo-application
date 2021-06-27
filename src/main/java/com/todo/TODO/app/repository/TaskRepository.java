package com.todo.TODO.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.TODO.app.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
