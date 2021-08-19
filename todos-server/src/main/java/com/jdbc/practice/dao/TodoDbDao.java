package com.jdbc.practice.dao;

import com.jdbc.practice.entity.Todo;

import java.util.List;

public interface TodoDbDao {
    Todo getTodoById(int id);

    List<Todo> getTodos();

    boolean saveTodo(Todo todo);

    boolean saveTodos(List<Todo> todos) throws Exception;
}
