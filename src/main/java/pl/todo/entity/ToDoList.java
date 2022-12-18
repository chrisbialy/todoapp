package pl.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import pl.todo.entity.Users;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ToDoList {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String item;

    @ManyToOne(targetEntity= Users.class)
    @JoinColumn(name = "uid")
    private Users users;
}
