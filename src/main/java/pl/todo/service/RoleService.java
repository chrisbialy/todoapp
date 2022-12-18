package pl.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.todo.entity.Roles;
import pl.todo.repository.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {


    private final RoleRepository roleRepository;

    public List<Roles> findAll() {return  roleRepository.findAll();}

}
