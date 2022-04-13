package com.company.dom.dao;

import com.company.dom.modelo.Category;
import com.company.dom.modelo.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    private Connection connection;

    public CursoDAO(Connection connection){
        this.connection = connection;
    }

    public void save(Curso curso){
        try{
            String sql = "INSERT INTO curso (name, description) VALUES (?, ?)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, curso.getName());
                preparedStatement.setString(2, curso.getDescription());

                preparedStatement.execute();
                try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                    while(resultSet.next()){
                        curso.setId(resultSet.getInt(1));
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void saveCategory(Curso curso){
        try{
            String sql = "INSERT INTO curso (name, description, id_category) VALUES (?, ?, ?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                preparedStatement.setString(1, curso.getName());
                preparedStatement.setString(2, curso.getDescription());
                preparedStatement.setInt(3, curso.getIdCategory());

                preparedStatement.execute();
                try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                    while(resultSet.next()){
                        curso.setId(resultSet.getInt(1));
                    }
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Curso> list(){
        List<Curso> cursos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM curso";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.execute();
                trasFormarResultSetEmCurso(cursos, preparedStatement);
            }
            return cursos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void trasFormarResultSetEmCurso(List<Curso> cursos, PreparedStatement preparedStatement) {
        try(ResultSet resultSet = preparedStatement.getResultSet()){
            while(resultSet.next()){
                Curso curso = new Curso(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                cursos.add(curso);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Curso> search(Category category){
        List<Curso> cursos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM curso WHERE id_category = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1, category.getId());
                preparedStatement.execute();

                trasFormarResultSetEmCurso(cursos, preparedStatement);
            }
            return cursos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id){
        String sql = "DELETE FROM curso WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void alter(String name, String description, Integer id){
        String sql = "UPDATE curso c SET c.name = ?, c.description = ?, WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
