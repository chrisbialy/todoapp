package pl.todo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.todo.entity.Users;


public interface UserRepository extends JpaRepository<Users, Integer> {
    /*Users save (Users users);*/
    Users findUserByUsername(String username);
}
