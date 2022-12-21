package pl.todo.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserToDoListDto {

    private Integer userID;
    private String username;
    private String ToDoItem;
}
