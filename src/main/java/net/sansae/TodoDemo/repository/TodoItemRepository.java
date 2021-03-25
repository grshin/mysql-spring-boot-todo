package net.sansae.TodoDemo.repository;

import net.sansae.TodoDemo.model.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

}