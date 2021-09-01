package com.jdbc.practice.dao;

import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.exception.TodoDeleteException;
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
        String selectTodoByIdSql = "SELECT * FROM todos WHERE id=?";

        return jdbcTemplate.queryForObject(selectTodoByIdSql, todoMapper, id);
    }

    @Override
    public List<Todo> getTodos() {
        String selectTodosSql = "SELECT * FROM todos";

        return jdbcTemplate.query(selectTodosSql, todoMapper);
    }

    @Override
    @Transactional
    public void saveTodo(Todo todo) throws TodoSaveException {
        String saveTodoSql = "INSERT INTO todos values(?, ?, ?, ?)";
        try {
            jdbcTemplate.update(saveTodoSql, todo.getUserId(), todo.getId(), todo.getTitle(), todo.isCompleted());

        } catch (DataAccessException exception) {

            exception.printStackTrace();
            throw new TodoSaveException("Unable to save Todo.");
        }
    }

    @Override
    @Transactional
    public void saveTodos(List<Todo> todos) throws TodoSaveException {
        for (Todo todo : todos) {
            saveTodo(todo);
        }
    }

    @Override
    @Transactional
    public void deleteTodo(int todoId) throws TodoDeleteException {
        String todoDeleteSql = "DELETE FROM todos WHERE id = ?";
        try {
            jdbcTemplate.update(todoDeleteSql, todoId);

        } catch (DataAccessException exception) {
            exception.printStackTrace();
            throw new TodoDeleteException("Unable to delete Todo.");
        }
    }
}
