package com.jdbc;

import com.jdbc.dao.ProdutoDao;
import com.jdbc.factory.ConnetionFactory;
import com.jdbc.modelo.Product;

import java.sql.*;
import java.util.List;

public class TestInsertionAndListProduct {
    public static void main(String[] args) throws SQLException {

        Product pro = new Product("HL7", "Usada como medio de comunicacao");

        try(Connection conn = new ConnetionFactory().recoverConnection()){
            ProdutoDao produtoDao = new ProdutoDao(conn);
            produtoDao.salvar(pro);
            List<Product> productList = produtoDao.listar();
            productList.stream().forEach(lp -> System.out.println(lp));
        }
        System.out.println(pro);

    }
}
