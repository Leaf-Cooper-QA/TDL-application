package com.qa.SpringTDL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.SpringTDL.domain.Todo;
import com.qa.SpringTDL.repo.TodoRepo;

@Service
public class TodoService {
	
	private TodoRepo repo;
	
	@Autowired
	public TodoService(TodoRepo repo) {
		this.repo=repo;
	}
	
	public List<Todo> getall() {
		return this.repo.findAll();
	}
	
	
	public Todo post(Todo todo) {
		return this.repo.saveAndFlush(todo);
	}
	
	public Long delete(Long id) {
		this.repo.deleteById(id);
		return id;
	}
	
	public Todo update(Todo todo) {
		Todo updated = this.repo.getById(todo.getId());
		updated.setName(todo.getName());
		updated.setDescription(todo.getDescription());
		updated.setTime(todo.getTime());
		return this.repo.saveAndFlush(updated);
	}

}
