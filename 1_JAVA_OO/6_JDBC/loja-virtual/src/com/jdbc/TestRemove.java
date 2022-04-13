package com.jdbc;

import com.jdbc.factory.ConnetionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestRemove {
    public static void main(String[] args) throws SQLException {
        int aux = 7;

        ConnetionFactory connFact = new ConnetionFactory();
        Connection conn = connFact
                .recoverConnection();

        PreparedStatement psm = conn
                .prepareStatement("DELETE FROM produto WHERE id > ?");

        psm.setInt(1, aux);
        psm.execute();

        Integer modifiedLines = psm.getUpdateCount();

        System.out.println("Number of lines modified: "+ modifiedLines);
    }
}
