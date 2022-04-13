package com.jdbc;

import com.jdbc.factory.ConnetionFactory;

import java.sql.*;

public class TestInsert {

    public static void main(String[] args) throws SQLException {
        ConnetionFactory connFact = new ConnetionFactory();
        Connection conn = connFact
                .recoverConnection();

        PreparedStatement psm = conn
                .prepareStatement("INSERT INTO produto (name, description) " +
                        "VALUES ('Rust', 'Novo linguagem de programacao')"
                , Statement.RETURN_GENERATED_KEYS);

        psm.execute();
        ResultSet rst = psm.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("O id criado foi "+id);
        }
    }


}
