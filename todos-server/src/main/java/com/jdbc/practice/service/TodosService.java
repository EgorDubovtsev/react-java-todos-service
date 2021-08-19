package com.jdbc.practice.service;

import com.jdbc.practice.entity.Todo;

import java.util.List;

public interface TodosService {
    Todo fetchTodoFromRemote(int id);

    boolean saveTodo(Todo todo);

    boolean saveTodos(List<Todo> list);

    List<Todo> getTodos();
}
