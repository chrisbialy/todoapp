package pl.todo.mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.todo.dtos.UserToDoListDto;
import pl.todo.entity.ToDoList;

@Component
@RequiredArgsConstructor
public class UserToDoListMapper {



    public UserToDoListDto toDto(ToDoList toDoList) {

        return new UserToDoListDto(
        toDoList.getUsers().getUid(),
        toDoList.getUsers().getUsername(),
        toDoList.getItem()
        );
    }


}
