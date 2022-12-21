package pl.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.todo.dtos.UserToDoListDto;
import pl.todo.entity.ToDoList;
import pl.todo.mapper.UserToDoListMapper;
import pl.todo.repository.ToDoListRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoListService {


    private final ToDoListRepository toDoListRepository;
    private final UserToDoListMapper userToDoListMapper;

    public List<ToDoList> findAll() {return toDoListRepository.findAll(); }

    public ToDoList save(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    public boolean deleteById(Integer tid) {
        toDoListRepository.deleteById(tid);
        return  true;
    }

    public List<UserToDoListDto> findToDoListByUsers(String username) {
      return toDoListRepository.findToDoListByUsers(username)
              .stream()
              .map(userToDoListMapper::toDto)
              .collect(Collectors.toList());

    }
}
