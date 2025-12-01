package com.mycompany.proyectotarea1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * Panel de fondo con franjas diagonales en tonos pastel.
 *
 * @author Samii de las Heras Cózar
 */
public class BgPanel extends JPanel {

    private static final Color STRIPE1 = new Color(255, 200, 250); // tono 1
    private static final Color STRIPE2 = new Color(255, 250, 200); // tono 2
    private static final int STRIPE_WIDTH = 30; // ancho de franja

    public BgPanel() {
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Pintar franjas diagonales
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Fondo base
        g2.setColor(STRIPE1);
        g2.fillRect(0, 0, w, h);

        // Franjas diagonales (rotación 45º)
        g2.setColor(STRIPE2);

        // Rotación sobre el centro
        java.awt.geom.AffineTransform old = g2.getTransform();
        double cx = w / 2.0;
        double cy = h / 2.0;
        g2.rotate(Math.toRadians(-45), cx, cy);

        // Calcular cobertura suficiente tras rotación
        int cover = (int) Math.hypot(w, h) + STRIPE_WIDTH * 4;
        for (int x = -cover; x < cover; x += STRIPE_WIDTH * 2) {
            g2.fillRect(x, -cover, STRIPE_WIDTH, cover * 3);
        }

        // Restaurar transform
        g2.setTransform(old);
        g2.dispose();
    }

    // Do not force a preferred size so the frames keep their original sizes
    // and layout managers determine the appropriate sizing.
}
