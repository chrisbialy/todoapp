package pl.todo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ToDoListUserWithIdDto {
    private Integer tid;
    private String item;
    private String username;
}
