package com.vishnu.codaexrercise.rest;

import com.vishnu.codaexrercise.entity.Notes;
import com.vishnu.codaexrercise.entity.ToDo;
import com.vishnu.codaexrercise.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesRestController {
    private NotesService notesService;

    @Autowired
    public NotesRestController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping( consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public SavedResource saveToDo(@RequestBody Notes notes){
        return new SavedResource(notesService.saveNotes(notes));
    }

    @GetMapping
    @CrossOrigin
    public List<Notes> getAllCourses(){
        return notesService.getAllNotes();
    }
}
