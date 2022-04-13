package com.jdbc;

import com.jdbc.factory.ConnetionFactory;
import com.jdbc.modelo.Category;
import com.jdbc.dao.CategoryDao;
import com.jdbc.modelo.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestListCategory {

    public static void main(String[] args) throws SQLException {

        try(Connection conn = new ConnetionFactory().recoverConnection()){
            CategoryDao categoryDao = new CategoryDao(conn);
            System.out.println("lista de categorias");
            List<Category> categoryList = categoryDao.listWhitProduct();
            categoryList.stream().forEach(cl -> {
                        System.out.println("***" + cl.getName() + "***");
                for (Product produto : cl.getProduct()){
                    System.out.println(cl.getName()+ " - " +produto.getNome());
                }
            });
        }

    }
}
