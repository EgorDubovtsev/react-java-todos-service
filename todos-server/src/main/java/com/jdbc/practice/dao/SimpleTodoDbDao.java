package com.jdbc.practice.dao;

import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.exception.TodoSaveException;
import com.jdbc.practice.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class SimpleTodoDbDao implements TodoDbDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TodoMapper todoMapper;

    @Override
    public Todo getTodoById(int id) {
        String sql = "SELECT * FROM todos WHERE id=?";

        return jdbcTemplate.queryForObject(sql, todoMapper, id);
    }

    @Override
    public List<Todo> getTodos() {
        String sql = "SELECT * FROM todos";

        return jdbcTemplate.query(sql, todoMapper);
    }

    @Override
    @Transactional
    public void saveTodo(Todo todo) throws TodoSaveException {
        String sql = "INSERT INTO todos values(?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, todo.getUserId(), todo.getId(), todo.getTitle(), todo.isCompleted());
        } catch (DataAccessException ignore) {
            throw new TodoSaveException("Unable to save Todo. Todo with this id already exist");
        }
    }

    @Override
    @Transactional
    public void saveTodos(List<Todo> todos) throws TodoSaveException {
        for (Todo todo : todos) {
            saveTodo(todo);
        }
    }
}
