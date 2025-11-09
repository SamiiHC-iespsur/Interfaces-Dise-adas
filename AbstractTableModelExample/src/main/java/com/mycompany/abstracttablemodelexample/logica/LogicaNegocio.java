/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abstracttablemodelexample.logica;

import com.mycompany.abstracttablemodelexample.beans.alumnos;
import java.util.*;

/**
 *
 * @author alumnadotarde
 */
public class LogicaNegocio {
    public List<alumnos> listaAlumnos;

    public LogicaNegocio() {
        listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new alumnos("Sami", "DAM2"));
        listaAlumnos.add(new alumnos("David", "DAM1"));
        listaAlumnos.add(new alumnos("Jose", "ASIR1"));
        listaAlumnos.add(new alumnos("Jaime", "DAM2"));
        listaAlumnos.add(new alumnos("Gabriel", "DAM2"));
        listaAlumnos.add(new alumnos("Manuel", "DAM2"));
        listaAlumnos.add(new alumnos("Jose", "ASIR1"));
    }

    public List<alumnos> getListaAlumnos() {
        return listaAlumnos;
    }
    
    
    
}
