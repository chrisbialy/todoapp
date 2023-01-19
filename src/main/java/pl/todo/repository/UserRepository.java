package pl.todo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.todo.entity.Users;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Users, Integer> {
    /*Users save (Users users);*/
    //Optional<Users> findUserByUsername(String username);
    Users findUserByUsername(String username);
}
