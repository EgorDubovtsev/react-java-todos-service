package com.jdbc.practice.controller;

import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.exception.TodoDeleteException;
import com.jdbc.practice.exception.TodoSaveException;
import com.jdbc.practice.service.Fetcher;
import com.jdbc.practice.service.TemperatureInfoService;
import com.jdbc.practice.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class MainController {
    @Autowired
    private TodosService todosService;
    @Autowired
    private TemperatureInfoService temperatureInfoService;
    @Autowired
    private Fetcher fetcher;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodosListPage() {

        return ResponseEntity.ok(todosService.getTodos());
    }

    @GetMapping("/fetchedTodo/{id}")
    public ResponseEntity<Todo> fetchTodo(@PathVariable int id) throws TodoSaveException {
        Todo todo = todosService.fetchTodoFromRemote(id);
        todosService.saveTodo(todo);

        return ResponseEntity.ok(todo);
    }

    @GetMapping("/fullTemperatureInfo")
    public String getFullTemperatureInfo() {
        return temperatureInfoService.getFullTemperatureInfo();
    }

    @GetMapping("/fetchSeveral/{amount}")
    public ResponseEntity<HttpStatus> fetchSeveral(@PathVariable int amount) {
        fetcher.fetchSeveralTodos(amount);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete/todo/{todoId}")
    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable int todoId) throws TodoDeleteException {
        todosService.deleteTodo(todoId);

        return ResponseEntity.ok().build();
    }

}
