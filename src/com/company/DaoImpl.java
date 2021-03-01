package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImpl implements DAO {
    DbManager manager = new DbManager();

    @Override
    public Students getStudentByName(String name) {
        String sql = "select * from students where name = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        Students student = null;
        try {
            connection = manager.connect();
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            set = statement.executeQuery();
            while (set.next()){
                Long id = set.getLong("id");
                String nameof = set.getString("name");
                String surname = set.getString("surname");
                int age = set.getInt("age");
                student = new Students(id, nameof, surname,age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (set != null) {
                    set.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return student;
    }
}
