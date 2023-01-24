package pl.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.todo.dtos.TodolistuserDto;
import pl.todo.dtos.TodolistuserWithIdDto;
import pl.todo.entity.Todolist;
import pl.todo.mapper.UserToDoListMapper;
import pl.todo.repository.TodolistRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodolistService {


    private final TodolistRepository toDoListRepository;
    private final UserToDoListMapper userToDoListMapper;


    public List<TodolistuserWithIdDto> findAll() {
        return toDoListRepository.findAll()
                .stream()
                .map(todolist -> new TodolistuserWithIdDto(
                        todolist.getTid(),
                        todolist.getItem(),
                        todolist.getUsers().getUsername()
                ))
                .collect(Collectors.toList());
    }

    public Todolist findToDoListById(Integer tid) {

        return toDoListRepository.findById(tid).orElseThrow();
    }

    /* Adding items to ToDoList does not work as expected as it does not take userID [uid]
       into account when writing data to the DB. The uid in todolist table gets NULL value
       what results in not displaying a todolist per user */

    public Todolist save(TodolistuserDto toDoListUserDto) {
        return toDoListRepository.save(userToDoListMapper.toEntityToDoListUser(toDoListUserDto));
    }

    public boolean deleteById(Integer tid) {
        toDoListRepository.deleteById(tid);
        return  true;
    }

   public List<TodolistuserDto> findItemByUsername(String username) {
        return toDoListRepository.findTodolistByUsers_Username(username)
                .stream()
                .map(userToDoListMapper::toDto)
                .collect(Collectors.toList());

    }

}
