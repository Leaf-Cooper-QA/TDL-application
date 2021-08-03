package com.qa.SpringTDL.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.SpringTDL.domain.Todo;
import com.qa.SpringTDL.service.TodoService;

@RestController
public class TodoController {
	
	private TodoService service;
	
	@Autowired
	public TodoController(TodoService service) {
		this.service=service;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Todo>> getall() {
		return new ResponseEntity<>(this.service.getall(), HttpStatus.OK);
	}
	
	@GetMapping("/getone")
	public ResponseEntity<Todo> getone(@RequestBody Long id) {
		return new ResponseEntity<>(this.service.getone(id), HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<Todo> post(@RequestBody Todo todo) {
		return new ResponseEntity<>(this.service.post(todo), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(@RequestBody Long id) {
		return new ResponseEntity<>(this.service.delete(id), HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public ResponseEntity<Todo> update(@RequestBody Todo todo, @RequestBody Long id) {
		return new ResponseEntity<>(this.service.update(id, todo), HttpStatus.OK);
	}

}
