package pl.todo.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.todo.dtos.UserToDoListDto;
import pl.todo.entity.ToDoList;
import pl.todo.service.ToDoListService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todolist")
public class ToDoListController {


    private final ToDoListService toDoListService;

    @GetMapping
    public ResponseEntity<List<ToDoList>> getAllToDoLists() {return ResponseEntity.ok(toDoListService.findAll());}


    @PostMapping
    public ResponseEntity<ToDoList> save(@RequestBody ToDoList toDoList) {
        return ResponseEntity.ok(toDoListService.save(toDoList));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> deleteToDoList(@PathVariable Integer tid) {
        return ResponseEntity.ok(toDoListService.deleteById(tid));
    }

    @GetMapping("/username")
    public ResponseEntity<List<UserToDoListDto>> findToDoListByUsers(@PathVariable String username) {
        return ResponseEntity.ok(toDoListService.findToDoListByUsers(username));
    }

}
