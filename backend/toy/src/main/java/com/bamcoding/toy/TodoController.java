package com.bamcoding.toy;

import com.bamcoding.toy.todo.dto.ResponseDTO;
import com.bamcoding.toy.todo.dto.TodoDTO;
import com.bamcoding.toy.todo.entity.TodoEntity;
import com.bamcoding.toy.todo.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/test")
    public ResponseEntity<?> testTodo() {
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }
//
//    @RequestMapping("/list")
//    @ResponseBody
//    public Map<String,Object> getTodoList() {
//        Map<String,Object> retMap = new HashMap<>();
//        retMap.put("result","fail");
//
//        List<TodoEntity> todoVOList = todoService.findTodo();
//
//        if(todoVOList != null && todoVOList.size() > 0)
//        {
//            retMap.put("result","success");
//            retMap.put("todoVOList",todoVOList);
//        }
//
//        return retMap;
//    }
//
//    @RequestMapping("/delete")
//    @ResponseBody
//    public Map<String, Object> delteTodo(TodoDTO todoDTO) {
//        Map<String,Object> retMap = new HashMap<>();
//        retMap.put("result","fail");
//
//        try {
//            //데이터 변환
//            ModelMapper modelMapper = new ModelMapper();
//            TodoEntity todoEntity = new TodoEntity();
//            modelMapper.map(todoDTO, todoEntity);
//            System.out.println("dto : "+todoDTO.toString());
//            System.out.println("dto : "+todoEntity.toString());
//
//            todoService.deleteTodo(todoEntity);
//            retMap.put("result","success");
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//
//        return retMap;
//    }
//
//    @RequestMapping("/save")
//    @ResponseBody
//    public Map<String,Object> saveTodo(TodoDTO todoDTO){
//        Map<String,Object> retMap = new HashMap<>();
//        retMap.put("result","fail");
//
//        try {
//            //데이터 변환
//            ModelMapper modelMapper = new ModelMapper();
//            TodoEntity todoEntity = new TodoEntity();
//            modelMapper.map(todoDTO,todoEntity);
//
//            todoService.saveTodo(todoEntity);
//            retMap.put("result","success");
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//
//        return retMap;
//    }
}
