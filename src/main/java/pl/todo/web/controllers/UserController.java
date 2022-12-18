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
    private ResponseEntity<List<Users>> getAllUsers() {return ResponseEntity.ok(userService.findAll());}

    @GetMapping("/{id}")
    private ResponseEntity<Users> getUserById(@PathVariable Integer uid) {
        return ResponseEntity.ok(userService.findUserById(uid));
    }

    @PostMapping
    private ResponseEntity<Users> save(@RequestBody Users user) {
        return ResponseEntity.ok(userService.save(user));
    }

}
