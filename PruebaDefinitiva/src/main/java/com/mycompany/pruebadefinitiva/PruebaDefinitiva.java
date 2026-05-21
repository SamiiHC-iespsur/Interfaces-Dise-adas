package com.mycompany.pruebadefinitiva;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;

public class PruebaDefinitiva {

    static void applyLookAndFeel() {
        try {
            FlatDarkLaf.setup();
        } catch (Exception ex) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignore) {
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            applyLookAndFeel();
            new VistaLogin().setVisible(true);
        });
    }

}
