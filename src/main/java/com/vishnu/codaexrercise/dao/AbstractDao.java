package com.vishnu.codaexrercise.dao;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class  AbstractDao<T> implements Dao<T> {
protected Connection connection;

public AbstractDao() {
    DbConnection dataBaseConnection = new DbConnection();
    connection = dataBaseConnection.getConnection();
}

public int save(T t){

    try {
        PreparedStatement saveStatement = getSaveStatement(t);
        if(saveStatement.executeUpdate() !=1 ){
            throw new RuntimeException("can not save object ");
        }
        ResultSet resultSet = saveStatement.getGeneratedKeys();
        resultSet.next();
        return resultSet.getInt(1);
    } catch (SQLException e) {
        throw new RuntimeException("can not save object",e);
    }

}

public abstract PreparedStatement getSaveStatement(T t) throws SQLException;

    @Override
    public List<T> getAll() {

            List<T> entities = new ArrayList<>();
            try {

                ResultSet resultSet = getGetAllStatement().executeQuery();
                while (resultSet.next()) {
                    entities.add(getEntity(resultSet));
                }
                return entities;

            } catch (SQLException e) {
                throw new RuntimeException("can not get all entries",e);
            }
        }

    protected abstract T getEntity(ResultSet resultSet) throws SQLException;

    protected abstract PreparedStatement getGetAllStatement();
}
