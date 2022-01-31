package com.bamcoding.toy.todo.service.Impl;

import com.bamcoding.toy.todo.entity.TodoEntity;
import com.bamcoding.toy.todo.repository.TodoRepository;
import com.bamcoding.toy.todo.service.TodoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public String testService() {
        try {
            TodoEntity entity = TodoEntity.builder().title("My first todo item").userId("admin").build();
            todoRepository.save(entity);
            //TodoEntity savedEntity = todoRepository.findById(entity.getId()).get();
            //TodoEntity savedEntity = todoRepository.findByUserId(entity.getUserId()).get(0);
            TodoEntity savedEntity = todoRepository.findByUserIdAndId(entity.getUserId(),entity.getId()).get(0);

            return savedEntity.getTitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<TodoEntity> findTodo() {
        return null;
    }

    @Override
    public boolean deleteTodo(TodoEntity todoEntity) {
        return false;
    }

    @Override
    public boolean saveTodo(TodoEntity todoEntity) {
        return false;
    }
//

//
//    @Override
//    public List<TodoEntity> findTodo() {
//        return todoRepository.findAll();
//    }
//
//    @Override
//    public boolean deleteTodo(TodoEntity todoEntity) {
//        todoRepository.delete(todoEntity);
//        return true;
//    }
//
//    @Override
//    public boolean saveTodo(TodoEntity todoEntity) {
//        todoRepository.save(todoEntity);
//        return true;
//    }
}
