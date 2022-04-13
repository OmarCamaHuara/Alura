package com.jdbc.dao;

import com.jdbc.modelo.Category;
import com.jdbc.modelo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private final Connection conn;

    public CategoryDao(Connection conn) { this.conn = conn; }

    public List<Category> listar() throws SQLException {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM category";

        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()){
                while(rst.next()){
                    Category category =
                            new Category(rst.getInt(1), rst.getString(2));
                    categories.add(category);
                }

            }
        }
        return categories;
    }

    public List<Category> listWhitProduct() throws SQLException{
        Category latest = null;
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT c.id AS ID, c.name AS Categories, p.id AS ID, p.name AS Produtos, p.description AS Description\n" +
                "FROM category c \n" +
                "INNER JOIN produto p \n" +
                "WHERE c.id = p.category_id\n" +
                "ORDER BY c.name ; ";
        try(PreparedStatement prtm = conn.prepareStatement(sql)){
            prtm.execute();
            try(ResultSet rst = prtm.getResultSet()) {
                while(rst.next()){
                    if(latest == null || !latest.getName().equals(rst.getString(2))){
                        Category category =
                                new Category(rst.getInt(1), rst.getString(2));
                        latest = category;
                        categories.add(category);
                    }
                    Product product =
                            new Product(rst.getInt(3), rst.getString(4), rst.getString(5));
                    latest.addProduct(product);
                }
            }
        }

        return categories;
    }
}
