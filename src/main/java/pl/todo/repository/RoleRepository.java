package pl.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.todo.entity.Roles;
import pl.todo.entity.Users;

public interface RoleRepository extends JpaRepository<Roles, String> {

    Roles findRolesByRole(String role);
}