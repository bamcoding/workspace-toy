package com.example.hellojpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "Members")
public class Member {
    @Id
    @GeneratedValue
    private String id;

    @Column(length = 100)
    private String name;
}
