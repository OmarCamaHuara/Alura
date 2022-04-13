package com.jdbc.dao;

import com.jdbc.modelo.Category;
import com.jdbc.modelo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private final Connection conn;

    public ProdutoDao(Connection conn){
        this.conn = conn;
    }

    public void salvar(Product produto) throws SQLException {
        String sql = "INSERT INTO produto(name, description) VALUES(?,?)";

        try(PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescription());

            pstm.execute();

            try(ResultSet rst = pstm.getGeneratedKeys()){
                while(rst.next()){
                    produto.setId(rst.getInt(1));
                }
            }
        }
    }

    public List<Product> listar() throws SQLException{
        List<Product> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try(PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.execute();
            try (ResultSet rst = pstm.getResultSet()){
                while(rst.next()){
                    Product produto =
                            new Product(rst.getInt(1), rst.getString(2), rst.getString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

    public List<Product> buscar(Category cl) throws SQLException {
        List<Product> produtos = new ArrayList<>();
        System.out.println("lista de produtos");
        String sql = "SELECT * FROM produto WHERE id = ?";

        try(PreparedStatement prsm = conn.prepareStatement(sql)){
            prsm.setInt(1, cl.getId());
            prsm.execute();

            try(ResultSet rst = prsm.getResultSet()){
                while(rst.next()){
                    Product produto =
                            new Product(rst.getInt(1), rst.getString(2), rst.getString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }
}
