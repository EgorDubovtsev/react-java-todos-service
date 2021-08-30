package com.jdbc.practice.controller;

import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.exception.TodoSaveException;
import com.jdbc.practice.service.Fetcher;
import com.jdbc.practice.service.TemperatureInfoService;
import com.jdbc.practice.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
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
    public ResponseEntity<Todo> fetchTodo(@PathVariable int id) {
        try {
            Todo todo = todosService.fetchTodoFromRemote(id);
            todosService.saveTodo(todo);

            return ResponseEntity.ok(todo);

        }catch (RestClientException e){
            e.printStackTrace();

            return ResponseEntity.notFound().build();
        } catch (TodoSaveException e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/fetchList")
    public ResponseEntity<String> fetchListTodo() {
        List<Todo> todos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            todos.add(todosService.fetchTodoFromRemote(i));
        }
        try {
            todosService.saveTodos(todos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("One of todo is already exist");
        }

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @GetMapping("/fullTemperatureInfo")
    public String getFullTemperatureInfo() {
        return temperatureInfoService.getFullTemperatureInfo();
    }

    @GetMapping("/fetchSeveral/{amount}")
    public ResponseEntity<HttpStatus> fetchSeveral(@PathVariable int amount) {
        fetcher.fetchSeveralTodos(amount);//add exception throwing

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
