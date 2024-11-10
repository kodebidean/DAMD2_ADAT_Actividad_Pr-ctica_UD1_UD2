package com.kodeleku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JDBCinit {

    private static final String url = "jdbc:postgresql://localhost:5433/alumnosdb";
    private static final String user = "postgres";
    private static final String password = "wnl1gsx2hy";


    public void createTableSQL() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS alumnos ("
                + "id SERIAL PRIMARY KEY, "
                + "nombre VARCHAR(50), "
                + "apellido VARCHAR(50), "
                + "curso VARCHAR(10), "
                + "dni VARCHAR(9) UNIQUE)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
            System.out.println("Tabla 'alumnos' creada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
