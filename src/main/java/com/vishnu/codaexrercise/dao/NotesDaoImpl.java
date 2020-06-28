package com.vishnu.codaexrercise.dao;

import com.vishnu.codaexrercise.entity.Notes;
import com.vishnu.codaexrercise.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class NotesDaoImpl extends AbstractDao<Notes> {
    private PreparedStatement saveStatement;
    private PreparedStatement getAllStatement;

    @Autowired
    public NotesDaoImpl() {
        createSaveStatement();
        createGetAllStatement();
    }


    private void createSaveStatement() {
        try {
            saveStatement = connection.prepareStatement("insert into notes(description)" +
                    "values(?)", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            throw new RuntimeException("Can not create PreparedStatement to create notes",e);
        }

    }

    @Override
    public PreparedStatement getSaveStatement(Notes notes) throws SQLException {
        saveStatement.setString(1,notes.getDescription());
        return saveStatement;
    }

    private void createGetAllStatement() {
        try {
            getAllStatement = connection.prepareStatement("select * from notes");
        } catch (SQLException e) {
            throw new RuntimeException("Can not create PreparedStatement to get notes", e);
        }
    }


    @Override
    protected Notes getEntity(ResultSet resultSet) throws SQLException {
        int notesId = resultSet.getInt("notes_id");
        String description = resultSet.getString("description");
        return new Notes(notesId, description);
    }

    @Override
    protected PreparedStatement getGetAllStatement() {
        return getAllStatement;
    }
}
