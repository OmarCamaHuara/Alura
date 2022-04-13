package com.company.dom.controller;

import com.company.dom.dao.CategoryDAO;
import com.company.dom.factory.ConnectionFactory;
import com.company.dom.modelo.Category;

import java.sql.Connection;
import java.util.List;

public class CategoryController {
    private CategoryDAO categoryDAO;

    public CategoryController(){
        Connection connection = new ConnectionFactory().recoverConnection();
        this.categoryDAO = new CategoryDAO(connection);
    }

    public List<Category> list(){
        return this.categoryDAO.list();
    }
}
