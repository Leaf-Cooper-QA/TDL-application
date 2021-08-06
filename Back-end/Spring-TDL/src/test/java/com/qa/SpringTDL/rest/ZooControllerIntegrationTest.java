package com.qa.SpringTDL.rest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.SpringTDL.domain.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ZooControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		
		//set up
		Todo todo = new Todo("Do dishes", "Clean and dry dirty dishes", 10L);
		
		String todoAsJson = this.mapper.writeValueAsString(todo);

		
		//post
		RequestBuilder mockPostRequest = post("/post").contentType(MediaType.APPLICATION_JSON).content(todoAsJson);
		
		Todo savedTodo = new Todo(1L, "Do dishes", "Clean and dry dirty dishes", 10L);
		
		String savedTodoAsJson = this.mapper.writeValueAsString(savedTodo);
		
		ResultMatcher matchStatusCreated = status().isCreated();
		
		ResultMatcher matchBodyPost = content().json(savedTodoAsJson);
		
		this.mock.perform(mockPostRequest).andExpect(matchBodyPost).andExpect(matchStatusCreated);
		
		
		//getall
		RequestBuilder mockGetRequest = get("/getall");
		
		List<Todo> todoList = new ArrayList<>();
		todoList.add(savedTodo);
		
		String todoListAsJson = this.mapper.writeValueAsString(todoList);
		
		ResultMatcher matchStatusOk = status().isOk();
		
		ResultMatcher matchBodyGet = content().json(todoListAsJson);
		this.mock.perform(mockGetRequest).andExpect(matchBodyGet).andExpect(matchStatusOk);
		
		//put
		Todo updateTodo = new Todo(1L, "Vacuum", "Vacuum upstairs and downstairs", 25L);
		
		String updateTodoAsJson = this.mapper.writeValueAsString(updateTodo);
		
		RequestBuilder mockPutRequest = put("/put").contentType(MediaType.APPLICATION_JSON).content(updateTodoAsJson);
		
		
		ResultMatcher matchBodyPut = content().json(updateTodoAsJson);
		this.mock.perform(mockPutRequest).andExpect(matchBodyPut).andExpect(matchStatusOk);
		
		//delete
		Long deleteId = 1L;
		
		String idAsJson = this.mapper.writeValueAsString(deleteId);
		
		RequestBuilder mockDeleteRequest = delete("/delete").contentType(MediaType.APPLICATION_JSON).content(idAsJson);
		
		ResultMatcher matchBodyDelete = content().json(idAsJson);
		
		this.mock.perform(mockDeleteRequest).andExpect(matchBodyDelete).andExpect(matchStatusOk);
		
		
	}
	

}
