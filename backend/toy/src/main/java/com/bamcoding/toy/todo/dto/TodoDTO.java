package com.bamcoding.toy.todo.dto;

import com.bamcoding.toy.todo.entity.TodoEntity;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDTO {
    private String id;
    private String title;
    private boolean done;

    public TodoDTO(final TodoEntity entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }
}
