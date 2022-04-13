package com.company.dom;

import com.company.dom.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoverConnection();

        String sql = "SELECT * FROM curso";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();

        while(resultSet.next()){
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");

            System.out.println(id+" "+ name +" "+description);
        }
        connection.close();
    }
}
