package com.tuconjuntoapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexionDB {

    private static final String URL = System.getProperty(
            "db.url",
            "jdbc:mysql://localhost:3306/tuconjuntoapp?useSSL=false&serverTimezone=UTC"
    );
    private static final String USER = System.getProperty("db.user", "root");
    private static final String PASSWORD = System.getProperty("db.password", "");

    private ConexionDB() {
    }

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver JDBC de MySQL en el proyecto.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
