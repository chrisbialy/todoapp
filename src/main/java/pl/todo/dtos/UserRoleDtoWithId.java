package pl.todo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRoleDtoWithId {

    private Integer uid;
    private String username;
    private String firstname;
    private String lastname;
    private String role;
}
