package com.company.dom.dao;

import com.company.dom.modelo.Category;
import com.company.dom.modelo.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Category> list(){
        try{
            List<Category> categories = new ArrayList<>();
            String sql = "SELECT * FROM category";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.execute();
                try(ResultSet resultSet = preparedStatement.getResultSet()){
                    while(resultSet.next()){
                        Category category = new Category(
                                resultSet.getInt(1),
                                resultSet.getString(2)
                        );
                    }
                }
            }
            return categories;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Category> CursoList(){
        try{
            Category ultima = null;
            List<Category> categories = new ArrayList<>();

            String sql = "SELECT c.id, c.name, p.id, p.nome, p.description " +
                    "FROM category c INNER JOIN curso c " +
                    "ON c.id = p.id_category";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.execute();
                try(ResultSet resultSet = preparedStatement.getResultSet()){
                    while(resultSet.next()){
                        if(ultima == null || !ultima.getName().equals(resultSet.getString(2))){
                            Category category = new Category(resultSet.getInt(1), resultSet.getString(2));

                            categories.add(category);
                            ultima = category;
                        }
                        Curso curso = new Curso(resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
                        ultima.adicionar(curso);
                    }
                }
                return categories;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
