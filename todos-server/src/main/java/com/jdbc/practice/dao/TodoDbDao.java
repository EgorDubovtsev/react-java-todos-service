package com.jdbc.practice.dao;

import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.exception.TodoSaveException;

import java.util.List;

public interface TodoDbDao {
    Todo getTodoById(int id);

    List<Todo> getTodos();

    void saveTodo(Todo todo) throws TodoSaveException;

    void saveTodos(List<Todo> todos) throws TodoSaveException;
}
