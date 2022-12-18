package pl.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.todo.entity.ToDoList;

public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {
}