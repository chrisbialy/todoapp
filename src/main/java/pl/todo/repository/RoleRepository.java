package pl.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.todo.entity.Roles;

import java.util.List;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

    /*List<Roles> findRolesByRole(String role);*/

    Roles findRolesByRid(Integer rid);

    Roles findRolesByRole(String role);


}
