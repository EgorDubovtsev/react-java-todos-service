package com.jdbc.practice.service;

import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.exception.TodoSaveException;
import org.springframework.web.client.RestClientException;

import java.util.List;

public interface TodosService {
    Todo fetchTodoFromRemote(int id) throws RestClientException;

    void saveTodo(Todo todo) throws TodoSaveException;

    void saveTodos(List<Todo> list) throws TodoSaveException;

    List<Todo> getTodos();
}
