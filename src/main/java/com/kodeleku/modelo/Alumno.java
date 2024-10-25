package com.kodeleku.modelo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Alumno {
    @JacksonXmlProperty(localName = "nombre")
    private String nombre;

    @JacksonXmlProperty(localName = "apellido")
    private String apellido;

    @JacksonXmlProperty(localName = "curso")
    private String curso;

    @JacksonXmlProperty(localName = "dni")
    private String dni;

    // Constructor sin argumentos
    public Alumno() {
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
