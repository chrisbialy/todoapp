package pl.todo.mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.todo.dtos.TodolistuserDto;
import pl.todo.entity.Todolist;
import pl.todo.service.UserService;

@Component
@RequiredArgsConstructor
public class UserToDoListMapper {

    private final UserService userService;



    public Todolist toEntityToDoListUser(TodolistuserDto toDoListUserDto) {

        return new Todolist(
                toDoListUserDto.getItem(),
                userService.findUserByUsername(toDoListUserDto.getUsername()
                ));
    }

     public TodolistuserDto toDto(Todolist toDoList)
     {
        return new TodolistuserDto(
            toDoList.getItem(),
            toDoList.getUsers().getUsername()
                );
    }

}
