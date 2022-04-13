package com.jdbc;

import com.jdbc.factory.ConnetionFactory;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

       ConnetionFactory connFact = new ConnetionFactory();
       Connection conn = connFact.recoverConnection();

        PreparedStatement psm = conn.prepareStatement("SELECT id, name, description FROM produto");
        psm.execute();

        ResultSet rst = psm.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt("id");
            String name = rst.getString("name");
            String description = rst.getString("description");

            System.out.println(id +" "+ name +" "+description);
        }

        conn.close();
    }
}
