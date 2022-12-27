package pl.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.todo.dtos.UserRoleDto;
import pl.todo.entity.Users;
import pl.todo.mapper.UserRoleMapper;
import pl.todo.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final UserRoleMapper userRoleMapper;

    /*public List<Users> findAll() {return userRepository.findAll(); }*/

    public List<UserRoleDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(users -> new UserRoleDto(
                        users.getUsername(),
                        users.getFirstname(),
                        users.getLastname(),
                        users.getRoles().getRole()
                ))
                .collect(Collectors.toList());
    }

    public  Users findUserById(Integer uid) {
        return userRepository.findById(uid).orElseThrow();
    }

    /*public Users save(Users user) {
        return userRepository.save(user);
    }*/

    public Users save(UserRoleDto userRoleDto) {
        return userRepository.save(userRoleMapper.toEntityUser(userRoleDto));

    }


    public Users findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public boolean deleteById(Integer uid) {
        userRepository.deleteById(uid);
        return true;
    }

}
