/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpanelimage;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author alumnadotarde
 */
public class JPanelImage extends JPanel implements Serializable {

    private ImagenFondo imagenFondo;
    private boolean ratonPresionado = false;
    private Point puntoPresion;
    private ArrastreListener arrastreListener;

    public JPanelImage() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (ratonPresionado) {
                    Point posicionActual = e.getPoint();
                    if (Math.abs(puntoPresion.x-posicionActual.x) > 50) {
                        if (arrastreListener != null) {
                            arrastreListener.arrastre();
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ratonPresionado = true;
                puntoPresion = e.getPoint();
            }
            
        });
    }
    
    public void addArrastreListener(ArrastreListener arrastreListener) {
        this.arrastreListener = arrastreListener;
    }
    
    public void removeArrastreListener() {
        this.arrastreListener = null;
    }

    public ImagenFondo getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(ImagenFondo imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null && imagenFondo.getRutaImagen() != null && imagenFondo.getRutaImagen().exists()) {
            ImageIcon imageIcon = new ImageIcon(imagenFondo.getRutaImagen().getAbsolutePath());
            Graphics2D g2d = (Graphics2D) g;
            // Use the opacity from ImagenFondo, default to 1.0f if null or out of range
            float alpha = 1.0f;
            try {
                Float op = imagenFondo.getOpacidad();
                if (op != null) {
                    alpha = op.floatValue();
                }
            } catch (Exception ex) {
                // fall back to full opacity on any unexpected error
                alpha = 1.0f;
            }
            // clamp to [0,1]
            if (Float.isNaN(alpha) || alpha < 0f) {
                alpha = 0f;
            } else if (alpha > 1f) {
                alpha = 1f;
            }

            // set composite with desired alpha, draw using g2d so composite applies
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2d.drawImage(imageIcon.getImage(), 0, 0, null);
            // restore full opacity
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
    }

}
