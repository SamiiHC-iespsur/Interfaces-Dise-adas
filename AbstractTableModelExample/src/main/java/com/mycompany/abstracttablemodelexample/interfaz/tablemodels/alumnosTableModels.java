/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abstracttablemodelexample.interfaz.tablemodels;

import com.mycompany.abstracttablemodelexample.beans.alumnos;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnadotarde
 */
public class alumnosTableModels extends AbstractTableModel {
    
    private List<alumnos> listaAlumnos;
    private String[] columnas = {"Nombre", "Curso"};

    public alumnosTableModels(List listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    @Override
    public int getRowCount() {
        return listaAlumnos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return listaAlumnos.get(rowIndex).getNombre();
            case 1:
                return listaAlumnos.get(rowIndex).getCurso();           
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    
    
}
