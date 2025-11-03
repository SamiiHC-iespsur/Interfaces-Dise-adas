/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpanelimage;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author alumnadotarde
 */
public class ImagenFondoPropertyEditorSupport extends PropertyEditorSupport{
    private final ImagenFondoPanel imagenFondoPanel = new ImagenFondoPanel();
    

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return imagenFondoPanel;
    }

    @Override
    public String getJavaInitializationString() {
        ImagenFondo imagenFondo = imagenFondoPanel.getSectedValue();
        String ruta = imagenFondo.getRutaImagen().getAbsolutePath().replace("\\", "/");
        
        return "new jpanelimage.ImagenFondo(" +
               "new java.io.File(\"" + ruta + "\")," +
               imagenFondo.getOpacidad() + "f)";
    }

    @Override
    public Object getValue() {
        return imagenFondoPanel.getSectedValue();
    }
    
}
