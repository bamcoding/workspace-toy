package com.bamcoding.toy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo/v1")
public class TodoApiController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        String test = "responseBody test";
        System.out.println("test");
        return test;
    }

    @RequestMapping("/todoList")
    @ResponseBody
    public String getTodoList() {
        String test = "getTodoList test";

        List<TodoEntity> todoVOList = (List<TodoEntity>) todoRepository.findAll();

        if(todoVOList != null && todoVOList.size() > 0){
            System.out.println("size: "+todoVOList.size());
            for(TodoEntity todoVO : todoVOList) {
                Long seq = todoVO.getSeq();
                System.out.println(seq + ", " + todoVO.getTitle());
            }
        }

        System.out.println("getTodoList");
        return test;
    }
}
