package com.bamcoding.toy.todo.dto;

import com.bamcoding.toy.todo.entity.TodoEntity;
import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
    private String error;
    private List<T> data;
}
