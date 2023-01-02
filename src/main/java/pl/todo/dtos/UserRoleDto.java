package pl.todo.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRoleDto {

    private String username;
    private String firstname;
    private String lastname;
    @Email
    private String email;
    private String password;
    private String role;
}
