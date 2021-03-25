package net.sansae.TodoDemo.controller;

import net.sansae.TodoDemo.model.TodoItem;
import net.sansae.TodoDemo.model.TodoListViewModel;
import net.sansae.TodoDemo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class TodoDemoController {

    private static final Logger log = LoggerFactory.getLogger(TodoDemoController.class);


    @Autowired
    TodoService todoService;

    @RequestMapping("/")
    public String index(Model model) {
        ArrayList<TodoItem> todoList = todoService.getTodoLists();
        model.addAttribute("newitem", new TodoItem());
        model.addAttribute("items", new TodoListViewModel(todoList));
        return "index";
    }

    @PostMapping("/todos")
    public String addTodo(@ModelAttribute TodoItem requestItem) {
        TodoItem item = new TodoItem(requestItem.getCategory(), requestItem.getName());
        todoService.addTodo(item);
        return "redirect:/";
    }

    @PutMapping("/todos")
    public String updateTodo(@ModelAttribute TodoListViewModel requestItems) {
        for (TodoItem requestItem : requestItems.getTodoList() ) {
            TodoItem item = new TodoItem(requestItem.getCategory(), requestItem.getName());
            item.setComplete(requestItem.isComplete());
            item.setId(requestItem.getId());
            todoService.updateTodo(item);
        }
        return "redirect:/";
    }
}
