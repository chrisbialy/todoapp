package pl.todo.mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.todo.dtos.UserRoleDto;
import pl.todo.entity.Users;
import pl.todo.service.RoleService;


@Component
@RequiredArgsConstructor
public class UserRoleMapper {


    private final RoleService roleService;
    public Users toEntityUser(UserRoleDto userRoleDto) {

        return new Users(
                userRoleDto.getUsername(),
                userRoleDto.getFirstname(),
                userRoleDto.getLastname(),
                roleService.findRolesByRole(userRoleDto.getRole()
                ));
    }



}
