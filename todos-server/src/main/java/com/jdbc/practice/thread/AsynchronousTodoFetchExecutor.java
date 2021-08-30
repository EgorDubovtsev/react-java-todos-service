package com.jdbc.practice.thread;

import com.jdbc.practice.entity.Todo;
import com.jdbc.practice.exception.TodoSaveException;
import com.jdbc.practice.service.TodosService;

public class AsynchronousTodoFetchExecutor implements Runnable {
    private final int todoIdForFetch;
    private final TodosService todosService;

    public AsynchronousTodoFetchExecutor(int todoIdForFetch, TodosService todosService) {
        this.todoIdForFetch = todoIdForFetch;
        this.todosService = todosService;
    }

    @Override
    public void run() {
        Todo todo = todosService.fetchTodoFromRemote(todoIdForFetch);
        try {
            todosService.saveTodo(todo);
        } catch (TodoSaveException e) {
            e.printStackTrace();
        }
    }
}
