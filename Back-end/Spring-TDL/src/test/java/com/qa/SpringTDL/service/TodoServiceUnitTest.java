package com.qa.SpringTDL.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.SpringTDL.domain.Todo;
import com.qa.SpringTDL.repo.TodoRepo;

@SpringBootTest
public class TodoServiceUnitTest {
	
	@MockBean
	private TodoRepo repo;
	
	@Autowired
	private TodoService service;
	
	@Test
	public void testCreateUnit() {
		
		Todo item = new Todo("do dishes","clean and dry dirty dishes", 10L);
		Todo itemWithId = new Todo(1L, "do dishes","clean and dry dirty dishes", 10L);
		
		Mockito.when(this.repo.saveAndFlush(item)).thenReturn(itemWithId);
		
		assertThat(this.service.post(item)).isEqualTo(itemWithId);
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(item);
		
	}
	
	@Test
	public void testReadAll() {

		Todo item1 = new Todo(1L, "do dishes","clean and dry dirty dishes", 10L);
		Todo item2 = new Todo(2L, "vacuum","vacuum upstairs and downstairs", 25L);
		List<Todo> todoList = new ArrayList<>();
		todoList.add(item1);
		todoList.add(item2);
		
		Mockito.when(this.repo.findAll()).thenReturn(todoList);
		
		assertThat(this.service.getall()).isEqualTo(todoList);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	
	//I'm suspicious of this one, it works but something feels off
	@Test
	public void testUpdateUnit() {
		//these have the same id, yes it's deliberate, not it's not what I'm suspicious of
		Todo item1 = new Todo(1L, "do dishes","clean and dry dirty dishes", 10L);
		Todo item2 = new Todo(1L, "vacuum","vacuum upstairs and downstairs", 25L);
		
		Mockito.when(this.repo.getById(1L)).thenReturn(item2);
		Mockito.when(this.repo.saveAndFlush(item2)).thenReturn(item1);
		
		assertThat(this.service.update(item1)).isEqualTo(item1);
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(item2);
		Mockito.verify(this.repo, Mockito.times(1)).getById(1L);
		
	}
	
	@Test
	public void testDeleteUnit() {
		Long id = 1L;
		
		assertThat(this.service.delete(id)).isEqualTo(id);
	}

}
