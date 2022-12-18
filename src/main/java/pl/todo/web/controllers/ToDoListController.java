package pl.todo.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.todo.entity.ToDoList;
import pl.todo.repository.ToDoListRepository;
import pl.todo.service.ToDoListService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todolist")
public class ToDoListController {

    private final ToDoListService toDoListService;

    @GetMapping
    private ResponseEntity<List<ToDoList>> getAllToDoLists() {return ResponseEntity.ok(toDoListService.findAll());}


}
