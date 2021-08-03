package com.qa.SpringTDL.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.SpringTDL.domain.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo,Long>{

}
