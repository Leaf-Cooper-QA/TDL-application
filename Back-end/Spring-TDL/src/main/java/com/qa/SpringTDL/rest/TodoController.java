package com.qa.SpringTDL.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.SpringTDL.domain.Todo;
import com.qa.SpringTDL.service.TodoService;

@RestController
@CrossOrigin
public class TodoController {
	
	private TodoService service;
	private String uri = "localhost:8080/";
	
	@Autowired
	public TodoController(TodoService service) {
		this.service=service;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Todo>> getall() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(uri));
		return new ResponseEntity<>(this.service.getall(),headers, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/post")
	public ResponseEntity<Todo> post(@RequestBody Todo todo) {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(uri));
		return new ResponseEntity<>(this.service.post(todo),headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(@RequestBody Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(uri));
		return new ResponseEntity<>(this.service.delete(id),headers, HttpStatus.OK);
	}
	
	@PutMapping("/put")
	//The update method is slightly cheaty because we're passing in the id as part of the item, don't worry about it
	public ResponseEntity<Todo> update(@RequestBody Todo todo) {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(uri));
		return new ResponseEntity<>(this.service.update(todo),headers, HttpStatus.OK);
	}

}
