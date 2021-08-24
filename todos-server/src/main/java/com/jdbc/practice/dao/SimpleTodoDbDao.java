package com.jdbc.practice.dao;

import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean saveTodo(Todo todo) {
        String sql = "INSERT INTO todos values(?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, todo.getUserId(), todo.getId(), todo.getTitle(), todo.isCompleted());

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    @Override
    @Transactional
    public boolean saveTodos(List<Todo> todos) throws Exception {
        for (Todo todo : todos) {
            if (!saveTodo(todo)) {
                throw new Exception("Unable to save Todo");
            }
        }
        return true;
    }
}
