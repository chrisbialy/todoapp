package pl.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.todo.entity.ToDoList;
import pl.todo.repository.ToDoListRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoListService {


    private final ToDoListRepository toDoListRepository;

    public List<ToDoList> findAll() {return toDoListRepository.findAll(); }
}
