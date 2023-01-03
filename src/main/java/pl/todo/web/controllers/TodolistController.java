package pl.todo.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.todo.dtos.TodolistuserDto;
import pl.todo.dtos.TodolistuserWithIdDto;
import pl.todo.entity.Todolist;
import pl.todo.service.TodolistService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todolist")
public class TodolistController {


    private final TodolistService toDoListService;

    @GetMapping
    public ResponseEntity<List<TodolistuserWithIdDto>> getAllToDoLists() {
        return ResponseEntity.ok(toDoListService.findAll());}

    @GetMapping("/{tid}")
    public ResponseEntity<Todolist> getToDoListById(@PathVariable Integer tid) {
        return ResponseEntity.ok(toDoListService.findToDoListById(tid));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<TodolistuserDto>> getItemByUsername(@PathVariable String username) {
        return ResponseEntity.ok(toDoListService.findItemByUsername(username));
    }


    @PostMapping("/addItem")
    public ResponseEntity<Todolist> saveToDoListUser(@RequestBody TodolistuserDto toDoListUserDto) {
        return ResponseEntity.ok(toDoListService.save(toDoListUserDto));
    }

    @DeleteMapping("deleteItem/{tid}")
    public ResponseEntity<Boolean> deleteToDoList(@PathVariable Integer tid) {
        return ResponseEntity.ok(toDoListService.deleteById(tid));
    }



}
