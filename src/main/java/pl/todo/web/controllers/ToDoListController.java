package pl.todo.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.todo.dtos.ToDoListUserDto;
import pl.todo.dtos.ToDoListUserWithIdDto;
import pl.todo.entity.ToDoList;
import pl.todo.service.ToDoListService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todolist")
public class ToDoListController {


    private final ToDoListService toDoListService;

    @GetMapping
    public ResponseEntity<List<ToDoListUserWithIdDto>> getAllToDoLists() {
        return ResponseEntity.ok(toDoListService.findAll());}

    @GetMapping("/{tid}")
    public ResponseEntity<ToDoList> getToDoListById(@PathVariable Integer tid) {
        return ResponseEntity.ok(toDoListService.findToDoListById(tid));
    }

    @PostMapping("/addItem")
    public ResponseEntity<ToDoList> saveToDoListUser(@RequestBody ToDoListUserDto toDoListUserDto) {
        return ResponseEntity.ok(toDoListService.save(toDoListUserDto));
    }

    @DeleteMapping("/{tid}")
    public ResponseEntity<Boolean> deleteToDoList(@PathVariable Integer tid) {
        return ResponseEntity.ok(toDoListService.deleteById(tid));
    }



}
