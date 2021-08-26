package com.jdbc.practice.controller;

import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.service.TemperatureInfoService;
import com.jdbc.practice.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("/api")
@RestController
public class MainController {
    @Autowired
    private TodosService todosService;
    @Autowired
    private TemperatureInfoService temperatureInfoService;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodosListPage() {

        return ResponseEntity.ok(todosService.getTodos());
    }

    @GetMapping("/fetchedTodo/{id}")
    public ResponseEntity<Todo> fetchTodo(@PathVariable int id) {
        Todo todo = todosService.fetchTodoFromRemote(id);
        todosService.saveTodo(todo);

        return ResponseEntity.ok(todo);
    }

    @GetMapping("/fetchList")
    public String fetchListTodo() {
        Todo todo1 = todosService.fetchTodoFromRemote(1);
        Todo todo2 = todosService.fetchTodoFromRemote(2);
        Todo todo3 = todosService.fetchTodoFromRemote(3);
        Todo todo4 = todosService.fetchTodoFromRemote(4);
        List<Todo> todos = Stream.of(todo1, todo2, todo3, todo4).collect(Collectors.toList());
        todosService.saveTodos(todos);

        return "200";
    }

    @GetMapping("/fullTemperatureInfo")
    public String getFullTemperatureInfo() {
        return temperatureInfoService.getFullTemperatureInfo();
    }

}
