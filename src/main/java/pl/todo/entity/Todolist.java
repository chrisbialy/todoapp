package pl.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Todolist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String item;

    @ManyToOne(targetEntity= Users.class)
    @JoinColumn(name = "uid")
    private Users users;

    public Todolist(String item, Users users)  {
        this.item = item;
        this.users = users;
    }

    public Todolist(String item, Optional<Users> userByUsername) {
    }
}
