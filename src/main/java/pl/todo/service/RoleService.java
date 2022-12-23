package pl.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.todo.entity.Roles;
import pl.todo.entity.Users;
import pl.todo.repository.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {


    private final RoleRepository roleRepository;

    public List<Roles> findAll() {return  roleRepository.findAll();}

    public Roles findRoleById(final Integer rid) {
        return roleRepository.findRolesByRid(rid);
    }

    public Roles findRolesByRole(String role) {
        return roleRepository.findRolesByRole(role);
    }

}
