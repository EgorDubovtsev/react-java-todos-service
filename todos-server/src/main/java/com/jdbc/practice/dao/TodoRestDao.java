package com.jdbc.practice.dao;

import com.jdbc.practice.entity.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

public interface TodoRestDao {
    ResponseEntity<Todo> fetchTodo(int id) throws RestClientException;
}
