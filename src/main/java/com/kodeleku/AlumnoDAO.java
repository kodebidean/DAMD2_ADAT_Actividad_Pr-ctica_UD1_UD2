package com.kodeleku;

import com.kodeleku.modelo.Alumno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class AlumnoDAO {

    private static final String url = "jdbc:postgresql://localhost:5433/alumnosdb";
    private static final String user = "postgres";
    private static final String password = "wnl1gsx2hy";

    public int insertAlumnos(List<Alumno> alumnos) {
        String insertSQL = "INSERT INTO alumnos (nombre, apellido, curso, dni) VALUES (?, ?, ?, ?) "
                + "ON CONFLICT (dni) DO NOTHING";
        int count = 0;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            for (Alumno alumno : alumnos) {
                pstmt.setString(1, alumno.getNombre());
                pstmt.setString(2, alumno.getApellido());
                pstmt.setString(3, alumno.getCurso());
                pstmt.setString(4, alumno.getDni());
                count += pstmt.executeUpdate();
            }
            System.out.println("Número de alumnos insertados: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}

