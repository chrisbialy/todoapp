package pl.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.todo.entity.Users;
import pl.todo.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public List<Users> findAll() {return userRepository.findAll(); }

    public  Users findUserById(Integer uid) {return userRepository.findById(uid).orElseThrow();}

    public Users save(Users user) {
        return userRepository.save(user);

    }

    public boolean deleteById(Integer uid) {
        userRepository.deleteById(uid);
        return true;
    }

}
