package com.jdbc.practice.service;

import com.jdbc.practice.dao.TodoDbDao;
import com.jdbc.practice.dao.TodoRestDao;
import com.jdbc.practice.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleTodoService implements TodosService {
    @Autowired
    private TodoRestDao todoRestDao;
    @Autowired
    private TodoDbDao todoDbDao;

    @Override
    public Todo fetchTodoFromRemote(int id) {

        return todoRestDao.fetchTodo(id).getBody();
    }

    @Override
    public boolean saveTodo(Todo todo) {

        return todoDbDao.saveTodo(todo);
    }

    @Override
    public boolean saveTodos(List<Todo> list) {
        try {
            return todoDbDao.saveTodos(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Todo> getTodos() {

        return todoDbDao.getTodos();
    }

}
