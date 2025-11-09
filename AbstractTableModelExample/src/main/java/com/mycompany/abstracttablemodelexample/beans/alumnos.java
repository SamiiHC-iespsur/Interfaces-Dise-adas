/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abstracttablemodelexample.beans;

/**
 *
 * @author alumnadotarde
 */
public class alumnos {
    private String nombre;
    private String curso;

    public alumnos(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }    
}
