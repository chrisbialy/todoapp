package pl.todo.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserToDoListDto {

    private Integer userId;
    private String username;
    private String ToDoItem;
}
