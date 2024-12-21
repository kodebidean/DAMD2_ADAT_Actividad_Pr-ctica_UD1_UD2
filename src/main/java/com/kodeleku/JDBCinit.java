package com.kodeleku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import io.github.cdimascio.dotenv.Dotenv;

public class JDBCinit {

    // Inicializar dotenv de forma estática
    static final Dotenv dotenv = Dotenv.load();

    private static final String url = "jdbc:postgresql://localhost:5433/alumnosdb";
    private static final String user = "postgres";
    private static final String password = dotenv.get("POSTGRES_PASSWORD");


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
