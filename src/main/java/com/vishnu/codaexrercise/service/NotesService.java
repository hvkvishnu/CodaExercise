package com.vishnu.codaexrercise.service;

import com.vishnu.codaexrercise.dao.NotesDaoImpl;
import com.vishnu.codaexrercise.entity.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotesService {
    private NotesDaoImpl notesDao;

    @Autowired
    public NotesService(NotesDaoImpl notesDao) {
        this.notesDao = notesDao;
    }

    public int saveNotes(Notes notes) {
        return notesDao.save(notes);
    }

    public List<Notes> getAllNotes() {
        return notesDao.getAll();
    }
}
