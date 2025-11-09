package com.mycompany.proyectotarea1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * A simple panel that paints a striped orange background.
 */
public class StripedOrangePanel extends JPanel {

    private static final Color STRIPE1 = new Color(255, 200, 250); // orange
    private static final Color STRIPE2 = new Color(255, 250, 200); // lighter orange
    private static final int STRIPE_WIDTH = 30; // pixels

    public StripedOrangePanel() {
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Paint diagonal stripes
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // fill background with first color
        g2.setColor(STRIPE1);
        g2.fillRect(0, 0, w, h);

        // draw diagonal stripes of STRIPE2 at 45 degrees by rotating the graphics context
        g2.setColor(STRIPE2);

        // rotate around center
        java.awt.geom.AffineTransform old = g2.getTransform();
        double cx = w / 2.0;
        double cy = h / 2.0;
        g2.rotate(Math.toRadians(-45), cx, cy);

        // after rotation, cover a large area so stripes fill the whole component
        int cover = (int) Math.hypot(w, h) + STRIPE_WIDTH * 4;
        for (int x = -cover; x < cover; x += STRIPE_WIDTH * 2) {
            g2.fillRect(x, -cover, STRIPE_WIDTH, cover * 3);
        }

        // restore transform
        g2.setTransform(old);
        g2.dispose();
    }

    // Do not force a preferred size so the frames keep their original sizes
    // and layout managers determine the appropriate sizing.

}
