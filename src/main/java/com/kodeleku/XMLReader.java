package com.kodeleku;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kodeleku.modelo.Alumno;
import com.kodeleku.modelo.Alumnos;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLReader {

    public static List<Alumno> parseXML(String filePath) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            Alumnos alumnoWrapper = xmlMapper.readValue(new File(filePath), Alumnos.class);
            System.out.println("Datos leídos correctamente");
            return alumnoWrapper.getAlumno();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

