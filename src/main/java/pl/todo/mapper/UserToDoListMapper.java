package pl.todo.mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.todo.dtos.ToDoListUserDto;
import pl.todo.entity.ToDoList;
import pl.todo.service.UserService;

@Component
@RequiredArgsConstructor
public class UserToDoListMapper {

    private final UserService userService;



    public ToDoList toEntityToDoListUser(ToDoListUserDto toDoListUserDto) {

        return new ToDoList(
                toDoListUserDto.getItem(),
                userService.findUserByUsername(toDoListUserDto.getUsername()
                ));
    }

}
