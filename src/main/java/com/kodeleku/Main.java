package com.kodeleku;

import com.kodeleku.modelo.Alumno;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Inicializar base de datos y crear tabla si no existe
            JDBCinit dbInitializer = new JDBCinit();
            dbInitializer.createTableSQL();

            // Leer y parsear el XML
            XMLReader xmlReader = new XMLReader();
            List<Alumno> alumnos = xmlReader.parseXML("src/main/resources/alumnos.xml");

            // Insertar datos en la base de datos
            AlumnoDAO alumnoDAO = new AlumnoDAO();
            int insertedCount = alumnoDAO.insertAlumnos(alumnos);

            // Imprimir la cantidad de alumnos insertados
            System.out.println("Total de alumnos insertados: " + insertedCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}