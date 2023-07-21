package com.github.damaralucena.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {

	private static final String URL = "jdbc:postgresql://localhost:5432/library_management_system";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
