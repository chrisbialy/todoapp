package pl.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.todo.entity.Todolist;
import java.util.List;

public interface TodolistRepository extends JpaRepository<Todolist, Integer> {

  List<Todolist> findTodolistByUsersUsernameIsLike(String username);

}
