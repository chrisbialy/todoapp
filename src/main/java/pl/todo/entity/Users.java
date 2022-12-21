package pl.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.todo.entity.Roles;

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
    private String first;
    private String lastname;

    @ManyToOne(targetEntity= Roles.class)
    @JoinColumn(name = "rid")
    private Roles roles;



}
