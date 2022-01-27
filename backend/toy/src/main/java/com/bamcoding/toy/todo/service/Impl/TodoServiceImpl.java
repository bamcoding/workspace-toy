package com.bamcoding.toy.todo.service.Impl;

import com.bamcoding.toy.todo.entity.TodoEntity;
import com.bamcoding.toy.todo.repository.TodoRepository;
import com.bamcoding.toy.todo.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public List<TodoEntity> findTodo() {
        return todoRepository.findAll();
    }

    @Override
    public boolean deleteTodo(TodoEntity todoEntity) {
        todoRepository.delete(todoEntity);
        return true;
    }

    @Override
    public boolean saveTodo(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
        return true;
    }
}
