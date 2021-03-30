package com.mysimpleproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysimpleproject.bean.UserBean;

public class RegisterDao {
public int userBean(UserBean userbean) throws ClassNotFoundException {
        
        
        String INSERT_USERS_SQL = "INSERT INTO newlogin" +
            "  (name, email, username, address, password) VALUES " +
            " (?, ?, ?, ?, ?);";
        
        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");

        //Step 1: Established the connection with database
      try (Connection connection = DriverManager
     .getConnection("jdbc:mysql://localhost:3306/newlogin?useSSL=false", "root", "root@786");

        // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement =  connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1,userbean.getName());
            preparedStatement.setString(2,userbean.getEmail());
            preparedStatement.setString(3,userbean.getUsername());
            preparedStatement.setString(4,userbean.getAddress());
            preparedStatement.setString(5,userbean.getPassword());

        // Step 3: Execute the query or update query
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
