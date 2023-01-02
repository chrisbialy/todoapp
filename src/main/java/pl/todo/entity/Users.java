package pl.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String username;
    private String firstname;
    private String lastname;
    @Email
    private String email;
    private String password;

    @ManyToOne(targetEntity = Roles.class)
    @JoinColumn(name = "rid")
    private Roles roles;


    public Users(String username, String firstname, String lastname, String email, String password, Roles roles) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;

    }

}

