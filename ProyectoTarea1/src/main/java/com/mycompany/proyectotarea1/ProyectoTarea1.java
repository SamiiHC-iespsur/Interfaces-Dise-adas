// Eliminado comentario de plantilla NetBeans
package com.mycompany.proyectotarea1;

/**
 * Punto de entrada de la aplicación. Inicializa y muestra la
 * {@link PantallaPrincipal}. Imprime un saludo de bienvenida en la salida
 * estándar.
 *
 * @author Samii de las Heras Cózar
 */
public class ProyectoTarea1 {

    /**
     * Método main de arranque.
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("¡Hola! Bienvenidx a mi juego.");
        PantallaPrincipal clicker = new PantallaPrincipal();
        clicker.setVisible(true);
    }
}
