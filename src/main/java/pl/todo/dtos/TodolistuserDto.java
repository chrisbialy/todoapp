package pl.todo.dtos;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TodolistuserDto {

    private String item;
    private String username;
}
