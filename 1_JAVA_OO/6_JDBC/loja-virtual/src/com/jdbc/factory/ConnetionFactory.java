package com.jdbc.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnetionFactory {

    public DataSource dataSource;

    public ConnetionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://192.168.15.60/loja_virtual?Timezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("domar");
        comboPooledDataSource.setPassword("admin");

        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }

    public Connection recoverConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
