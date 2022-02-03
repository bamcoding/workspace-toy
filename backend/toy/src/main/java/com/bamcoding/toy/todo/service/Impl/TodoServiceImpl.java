package com.bamcoding.toy.todo.service.Impl;

import com.bamcoding.toy.todo.entity.TodoEntity;
import com.bamcoding.toy.todo.repository.TodoRepository;
import com.bamcoding.toy.todo.service.TodoService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
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
    public List<TodoEntity> create(TodoEntity entity) {
        //Validations
        validate(entity);

        todoRepository.save(entity);

        log.info("Entity Id : {} is saved.", entity.getId());

        return todoRepository.findByUserId(entity.getUserId());
    }

    @Override
    public List<TodoEntity> retrieve(String userId) {
        return todoRepository.findByUserId(userId);
    }

    @Override
    public List<TodoEntity> update(TodoEntity entity) {
        validate(entity);

        final Optional<TodoEntity> original = todoRepository.findById(entity.getId());

        original.ifPresent(todo -> {
            todo.setTitle(entity.getTitle());
            todo.setDone(entity.isDone());

            todoRepository.save(todo);
        });

        return retrieve(entity.getUserId());


    }

    @Override
    public List<TodoEntity> delete(TodoEntity entity) {
        validate(entity);

        try {
            todoRepository.delete(entity);
        } catch(Exception e){
            e.printStackTrace();
            log.error("error deleting entity ", entity.getId(),e);

            throw new RuntimeException("error deleting entity " + entity.getId());
        }

        return retrieve(entity.getUserId());
    }

    private void validate(final TodoEntity entity) {

        if(entity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        if(entity.getUserId() == null){
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }


}
