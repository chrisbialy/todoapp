package pl.todo.web.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.todo.dtos.UserRoleDto;
import pl.todo.dtos.UserRoleDtoWithId;
import pl.todo.entity.Users;
import pl.todo.repository.UserRepository;
import pl.todo.security.UserAuthenticationProvider;
import pl.todo.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @GetMapping()
    public ResponseEntity<List<UserRoleDtoWithId>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());}



    @GetMapping("/{uid}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer uid) {
        return ResponseEntity.ok(userService.findUserById(uid));
    }


    @GetMapping(path = "/username/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.findUserByUsername(username));

    }

    @GetMapping("/getUserRoles")
    public String getUserRoles(@RequestParam("username") String username) {
        return userService.getUserRoles(username);
    }

    // Optional
    /*@GetMapping("/username/{username}")
    public ResponseEntity<Optional<Users>> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.findUserByUsername(username));
    }*/


    @PostMapping("/addUser")
    public ResponseEntity<Users> saveUserWithRole(@RequestBody UserRoleDto userRoleDto) {
        return ResponseEntity.ok(userService.save(userRoleDto));
    }




    @DeleteMapping("/deleteuser/{uid}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer uid) {
        return ResponseEntity.ok(userService.deleteById(uid));
    }

}

