package com.jdbc;

import com.jdbc.factory.ConnetionFactory;

import java.sql.SQLException;

public class TestPoolConnetion {

    public static void main(String[] args) throws SQLException {
        ConnetionFactory conn = new ConnetionFactory();

        for (int i = 0; i < 20; i++){
            conn.recoverConnection();
            System.out.println("Number of connetion: "+ i);
        }
    }
}
