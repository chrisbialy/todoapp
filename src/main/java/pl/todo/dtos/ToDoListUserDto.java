package pl.todo.dtos;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ToDoListUserDto {

    private String item;
    private String username;
}
