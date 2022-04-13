package com.company.dom.controller;

import com.company.dom.dao.CursoDAO;
import com.company.dom.factory.ConnectionFactory;
import com.company.dom.modelo.Curso;

import java.sql.Connection;
import java.util.List;

public class CursoController {
    private CursoDAO cursoDAO;

    public CursoController(){
        Connection connection = new ConnectionFactory().recoverConnection();
        this.cursoDAO = new CursoDAO(connection);
    }
    public List<Curso> list(){
        return this.cursoDAO.list();
    }
}
