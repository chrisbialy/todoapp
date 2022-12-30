package pl.todo.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.todo.entity.Roles;
import pl.todo.service.RoleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {


    private final RoleService roleService;

    @GetMapping
    private ResponseEntity<List<Roles>> findAllRoles() {return ResponseEntity.ok(roleService.findAll());}

    @GetMapping("/{rid}")
    private ResponseEntity<Roles> findRoleByRid(@PathVariable Integer rid) {
        return ResponseEntity.ok(roleService.findRoleById(rid));
    }

}
