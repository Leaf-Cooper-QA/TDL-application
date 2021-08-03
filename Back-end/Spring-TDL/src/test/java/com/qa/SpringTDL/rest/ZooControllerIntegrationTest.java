package com.qa.SpringTDL.rest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class ZooControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testCreate() throws Exception {
		Todo todo = new Todo("Do dishes", "Clean and dry dirty dishes", 10L);
		
		String todoAsJson = this.mapper.writeValueAsString(todo);
		
		RequestBuilder mockRequest = post("/post").contentType(MediaType.APPLICATION_JSON).content(todoAsJson);
		
		Todo savedTodo = new Todo(1L, "Do dishes", "Clean and dry dirty dishes", 10L);
		
		String savedTodoAsJson = this.mapper.writeValueAsString(savedTodo);
		
		ResultMatcher matchStatus = status().isCreated();
		
		ResultMatcher matchBody = content().json(savedTodoAsJson);
		
		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}
	

}
