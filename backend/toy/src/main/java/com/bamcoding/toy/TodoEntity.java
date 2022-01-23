package com.bamcoding.toy;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="TODO_INFO")
public class TodoEntity {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String title;
    private String content;
    @Column(name = "creation_date")
    private String creationDate;
    @Column(name = "modified_date")
    private String modifiedDate;
    @Column(name = "user_name")
    private String userName;

}
