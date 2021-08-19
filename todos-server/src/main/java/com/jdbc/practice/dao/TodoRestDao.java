package com.jdbc.practice.dao;

import com.jdbc.practice.entity.Todo;
import org.springframework.http.ResponseEntity;

public interface TodoRestDao {
    ResponseEntity<Todo> fetchTodo(int id);
}
