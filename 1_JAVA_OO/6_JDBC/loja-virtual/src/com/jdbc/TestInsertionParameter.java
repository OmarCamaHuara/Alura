package com.jdbc;

import com.jdbc.factory.ConnetionFactory;

import java.sql.*;

public class TestInsertionParameter {
    public static void main(String[] args) throws SQLException {
        String name = "React";
        String description = "Curso avancado";

        ConnetionFactory connFact = new ConnetionFactory();

        try(Connection conn = connFact.recoverConnection()) {
            conn.setAutoCommit(false);

            try (
                    PreparedStatement psm =
                            conn.prepareStatement("INSERT INTO produto (name, description) VALUES (?, ?)"
                                    , Statement.RETURN_GENERATED_KEYS);
            ) {
                addVariable("HTML", "Curso para experientes", psm);
                addVariable("SASS", "Vamos conhecer esta nova tecnologia", psm);

                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTE");
                conn.rollback();
            }
        }
    }

    public static void addVariable(String name, String description, PreparedStatement psm) throws SQLException {
        psm.setString(1, name);
        psm.setString(2, description);

//        if(name.equals("SASS")){
//            throw new RuntimeException("Could not add product "+ name);
//        }

        psm.execute();

        try(ResultSet rst = psm.getGeneratedKeys()) {
            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println("The id created was: " + id);
            }
        }
    }
}
