package com.tuconjuntoapp;

import com.tuconjuntoapp.config.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        try (Connection conn = ConexionDB.conectar()) {
            System.out.println("La conexion funciona correctamente");
        } catch (SQLException e) {
            System.out.println("No se pudo conectar");
            e.printStackTrace();
        }
    }
}
