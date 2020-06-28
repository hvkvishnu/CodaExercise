package com.vishnu.codaexrercise.dao;

import com.vishnu.codaexrercise.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class TodoDaoImpl extends AbstractDao<ToDo> {
    private PreparedStatement saveStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement updateStatement;


    @Autowired
    public TodoDaoImpl() {
        createSaveStatement();
        createGetAllStatement();
        createUpdateStatement();
    }

    private void createUpdateStatement() {
        try {
            updateStatement = connection.prepareStatement("update todo SET description=? where todo_id=? ");
        }catch (SQLException e){
            throw new RuntimeException("can not create update statement ",e);

        }
    }


    private void createSaveStatement() {
            try {
                saveStatement = connection.prepareStatement("insert into todo(description)" +
                        "values(?)", Statement.RETURN_GENERATED_KEYS);
            } catch (SQLException e) {
                throw new RuntimeException("Can not create PreparedStatement to create todo" +
                        "",e);
            }

    }

    @Override
    public PreparedStatement getSaveStatement(ToDo toDo) throws SQLException {
        saveStatement.setString(1,toDo.getDescription());
        return saveStatement;
    }

    private void createGetAllStatement() {
        try {
            getAllStatement = connection.prepareStatement("select * from todo");
        } catch (SQLException e) {
            throw new RuntimeException("Can not create PreparedStatement to get todos", e);
        }
    }

    @Override
    protected ToDo getEntity(ResultSet resultSet) throws SQLException {
        int todoId = resultSet.getInt("todo_id");
        String description = resultSet.getString("description");
        return new ToDo(todoId, description);
    }

    @Override
    protected PreparedStatement getGetAllStatement() {
        return getAllStatement;
    }

    @Override
    protected PreparedStatement getUpdateStatement(int id, ToDo toDo) throws SQLException {
        updateStatement.setString(1,toDo.getDescription());
        updateStatement.setInt(2,id);
        return updateStatement;
    }
}
