package pl.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.todo.entity.Users;
import pl.todo.dtos.UserRoleDto;
import pl.todo.dtos.UserRoleDtoWithId;
import pl.todo.mapper.UserRoleMapper;
import pl.todo.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleMapper userRoleMapper;

    private final PasswordEncoder encoder;



/*    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByUsername(username)
                .map(UserDetailsAdapter::new)
                .orElseThrow(() -> new UsernameNotFoundException("userNameNotfound"));
    }*/

    public List<UserRoleDtoWithId> findAll() {
        return userRepository.findAll()
                .stream()
                .map(users -> new UserRoleDtoWithId(
                        users.getUid(),
                        users.getUsername(),
                        users.getFirstname(),
                        users.getLastname(),
                        users.getEmail(),
                        users.getRoles().getRole()
                ))
                .collect(Collectors.toList());
    }

    public String getUserRoles(String username) {
        return userRepository.findUserByUsername(username).getRoles().getRole();
    }

    public Users findUserByUsername(String username) {

        return userRepository.findUserByUsername(username);
    }


    // Optional

    /*public Optional<Users> findUserByUsername(String username) {

        return userRepository.findUserByUsername(username);
    }*/
    public  Users findUserById(Integer uid) {

        return userRepository.findById(uid).orElseThrow();
    }

    // save user with encoded password

    public Users save(UserRoleDto userRoleDto) {
        userRoleDto.setPassword(encoder.encode(userRoleDto.getPassword()));
        return userRepository.save(userRoleMapper.toEntityUser(userRoleDto));
    }

   /* public Users save(UserRoleDto userRoleDto) {
        return userRepository.save(userRoleMapper.toEntityUser(userRoleDto));

    }
*/
   /* public Users save(UserRoleDto userRoleDto) {
        return userRepository.save(userRoleMapper.toEntityUser(userRoleDto));

    }*/


    public boolean deleteById(Integer uid) {
        userRepository.deleteById(uid);
        return true;
    }

}
