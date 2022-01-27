package com.bamcoding.toy.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDTO {
    private Long seq;
    private String title;
    private String content;
    private String creationDate;
    private String modifiedDate;
    private String userName;
}
