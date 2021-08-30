package com.jdbc.practice.service;

import com.jdbc.practice.thread.AsynchronousTodoFetchExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ProfessionalFetcher implements Fetcher {
    @Autowired
    private TodosService todosService;

    @Override
    public void fetchSeveralTodos(int amount) {
        ExecutorService executorService = Executors.newFixedThreadPool(amount);
        for (int i = 0; i < amount; i++) {
            AsynchronousTodoFetchExecutor fetchExecutor = new AsynchronousTodoFetchExecutor(i, todosService);
            executorService.submit(fetchExecutor);
        }
    }
}
