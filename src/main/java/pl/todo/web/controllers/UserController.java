package pl.todo.web.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.todo.dtos.UserRoleDto;
import pl.todo.dtos.UserRoleDtoWithId;
import pl.todo.entity.Users;
import pl.todo.service.TodolistService;
import pl.todo.service.UserService;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")

public class UserController {


    private final TodolistService toDoListService;
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserRoleDtoWithId>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());}


    @GetMapping("/{uid}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer uid) {
        return ResponseEntity.ok(userService.findUserById(uid));
    }


    @GetMapping("/username/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.findUserByUsername(username));
    }

   /* @GetMapping("/todo/{username}")
    public ResponseEntity<List<ToDoListUserDto>> findToDoListByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.findListToDoByUsername(username));
    }
*/
   @PostMapping("/addUser")
    public ResponseEntity<Users> saveUserWithRole(@RequestBody UserRoleDto userRoleDto) {
        return ResponseEntity.ok(userService.save(userRoleDto));
    }

    @DeleteMapping("/deleteuser/{uid}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer uid) {
        return ResponseEntity.ok(userService.deleteById(uid));
    }

}
