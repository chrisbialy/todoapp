package pl.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.todo.entity.ToDoList;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {


    List<ToDoList> findToDoListByUsers(String username);
}
