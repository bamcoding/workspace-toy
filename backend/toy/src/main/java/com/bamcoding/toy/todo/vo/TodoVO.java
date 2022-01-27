package com.bamcoding.toy.todo.vo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
public class TodoVO {
    private Long seq;
    private String title;
    private String content;
    private String creationDate;
    private String modifiedDate;
    private String userName;
}
