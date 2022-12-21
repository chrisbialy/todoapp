package pl.todo.web.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.todo.entity.Users;
import pl.todo.service.UserService;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")

public class UserController {



    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {return ResponseEntity.ok(userService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer uid) {
        return ResponseEntity.ok(userService.findUserById(uid));
    }

    @PostMapping
    public ResponseEntity<Users> save(@RequestBody Users user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer uid) {
        return ResponseEntity.ok(userService.deleteById(uid));
    }

}
