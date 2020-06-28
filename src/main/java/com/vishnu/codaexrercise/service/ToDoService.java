package com.vishnu.codaexrercise.service;

import com.vishnu.codaexrercise.dao.TodoDaoImpl;
import com.vishnu.codaexrercise.entity.ToDo;
import com.vishnu.codaexrercise.rest.SavedResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToDoService {
    private TodoDaoImpl todoDao;

    @Autowired
    public ToDoService(TodoDaoImpl todoDao) {
        this.todoDao = todoDao;
    }

    public int saveToDo(ToDo toDo) {
       return todoDao.save(toDo);
    }

    public List<ToDo> getAllTodo() { return todoDao.getAll();}

    public void updateToDo(int id,ToDo todo) {
         todoDao.update(id,todo);
    }
}
