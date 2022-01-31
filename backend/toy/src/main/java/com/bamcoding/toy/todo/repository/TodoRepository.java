package com.bamcoding.toy.todo.repository;

import com.bamcoding.toy.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    @Query("select t from TodoEntity t where t.userId = ?1 and t.id = ?2")
    List<TodoEntity> findByUserIdAndId(String userId, String id);
    List<TodoEntity> findByUserId(String userId);
}