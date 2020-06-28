package com.vishnu.codaexrercise.rest;

import com.vishnu.codaexrercise.entity.ToDo;
import com.vishnu.codaexrercise.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/todo"})
public class ToDoRestController {
   private ToDoService toDoService;

   @Autowired
    public ToDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping( consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public SavedResource saveToDo(@RequestBody ToDo toDo){
        return new SavedResource(toDoService.saveToDo(toDo));
    }
    @PostMapping(path="/edit",consumes = "application/json")
    @CrossOrigin
    public void updateTodo(@RequestBody ToDo todo){
       toDoService.updateToDo(todo.getId(),todo);
    }
    @GetMapping
    @CrossOrigin
    public List<ToDo> getAllCourses(){
        return toDoService.getAllTodo();
    }
}
