package pl.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

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

    @ManyToOne(targetEntity = Roles.class)
    @JoinColumn(name = "rid")
    private Roles roles;


    public Users(String username, String firstname, String lastname, Roles roles) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.roles = roles;

    }

}

