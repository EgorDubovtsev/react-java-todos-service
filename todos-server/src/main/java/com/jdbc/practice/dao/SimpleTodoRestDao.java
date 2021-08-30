package com.jdbc.practice.dao;

import com.jdbc.practice.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Repository
public class SimpleTodoRestDao implements TodoRestDao {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<Todo> fetchTodo(int id) throws RestClientException {
        return restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/" + id, Todo.class);
    }
}
