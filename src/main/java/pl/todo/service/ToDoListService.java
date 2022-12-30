package pl.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.todo.dtos.ToDoListUserDto;
import pl.todo.dtos.ToDoListUserWithIdDto;
import pl.todo.entity.ToDoList;
import pl.todo.mapper.UserToDoListMapper;
import pl.todo.repository.ToDoListRepository;
import pl.todo.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoListService {


    private final ToDoListRepository toDoListRepository;
    private final UserToDoListMapper userToDoListMapper;


    public List<ToDoListUserWithIdDto> findAll() {
        return toDoListRepository.findAll()
                .stream()
                .map(toDoList -> new ToDoListUserWithIdDto(
                        toDoList.getTid(),
                        toDoList.getItem(),
                        toDoList.getUsers().getUsername()
                ))
                .collect(Collectors.toList());
    }

    public ToDoList findToDoListById(Integer tid) {

        return toDoListRepository.findById(tid).orElseThrow();
    }

    public ToDoList save(ToDoListUserDto toDoListUserDto) {
        return toDoListRepository.save(userToDoListMapper.toEntityToDoListUser(toDoListUserDto));
    }

    public boolean deleteById(Integer tid) {
        toDoListRepository.deleteById(tid);
        return  true;
    }

   /* public List<ToDoListUserDto> findListToDoByUsername(String username) {
        return toDoListRepository.findToDoListByUsername(username)
                .getUsers().getUsername();

    }*/

}
