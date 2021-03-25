package net.sansae.TodoDemo.service;

import net.sansae.TodoDemo.model.TodoItem;
import net.sansae.TodoDemo.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {
    @Autowired
    private TodoItemRepository repository;


    public ArrayList<TodoItem> getTodoLists() {
        return (ArrayList<TodoItem>) repository.findAll();
    }

    public void addTodo(TodoItem item) {
        repository.save(item);
    }

    public void updateTodo(TodoItem item) {
        repository.save(item);
    }
}
