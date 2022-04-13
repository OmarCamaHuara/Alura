package com.company.dom.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public DataSource dataSource;

    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(
                "jdbc:mysql://192.168.15.60/dom_cursos?Timezone=true&serverTimezone=UTC"
        );
        comboPooledDataSource.setUser("domar");
        comboPooledDataSource.setPassword("admin");
        this.dataSource = comboPooledDataSource;
    }

    public Connection recoverConnection(){
        try {
            return this.dataSource.getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
