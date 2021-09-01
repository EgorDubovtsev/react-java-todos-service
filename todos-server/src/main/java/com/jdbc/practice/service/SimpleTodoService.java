package com.jdbc.practice.service;

import com.jdbc.practice.dao.TodoDbDao;
import com.jdbc.practice.dao.TodoRestDao;
import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.exception.TodoDeleteException;
import com.jdbc.practice.exception.TodoSaveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Service
public class SimpleTodoService implements TodosService {
    @Autowired
    private TodoRestDao todoRestDao;
    @Autowired
    private TodoDbDao todoDbDao;

    @Override
    public Todo fetchTodoFromRemote(int id) throws RestClientException {
        return todoRestDao.fetchTodo(id).getBody();
    }

    @Override
    public void saveTodo(Todo todo) throws TodoSaveException {

        todoDbDao.saveTodo(todo);
    }

    @Override
    public void saveTodos(List<Todo> list) throws TodoSaveException {
        todoDbDao.saveTodos(list);
    }

    @Override
    public List<Todo> getTodos() {

        return todoDbDao.getTodos();
    }

    @Override
    public void deleteTodo(int todoId) throws TodoDeleteException {
        todoDbDao.deleteTodo(todoId);
    }


}
