package com.bamcoding.toy.todo;

import java.util.List;

public interface TodoService {

    String testService();

    List<TodoEntity> create(final TodoEntity entity);

    List<TodoEntity> retrieve(final String userId);

    List<TodoEntity> update(final TodoEntity entity);

    List<TodoEntity> delete(final TodoEntity entity);
}
