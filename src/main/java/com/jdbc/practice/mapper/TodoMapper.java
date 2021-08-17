package com.jdbc.practice.mapper;

import com.jdbc.practice.entity.Todo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class TodoMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet resultSet, int i) throws SQLException {
        Todo todo = new Todo();
        todo.setUserId(resultSet.getInt("userId"));
        todo.setId(resultSet.getInt("id"));
        todo.setTitle(resultSet.getString("title"));
        todo.setCompleted(resultSet.getBoolean("iscompleted"));

        return todo;
    }
}
