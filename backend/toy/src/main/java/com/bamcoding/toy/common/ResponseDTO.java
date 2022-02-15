package com.bamcoding.toy.common;

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
