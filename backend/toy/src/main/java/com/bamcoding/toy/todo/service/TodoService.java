package com.bamcoding.toy.todo.service;

import com.bamcoding.toy.todo.entity.TodoEntity;

import java.util.List;

public interface TodoService {

    List<TodoEntity> findTodo();

    boolean deleteTodo(TodoEntity todoEntity);

    boolean saveTodo(TodoEntity todoEntity);
}
