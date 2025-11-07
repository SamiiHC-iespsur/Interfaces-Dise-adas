/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JPanelEvaluacionPassword;

/**
 *
 * @author alumnadotarde
 */
public class MedidorPswd {

    // Valores posibles: 0 (inválida), 1, 2 (débil), 3, 4 (media), 5, 6 (fuerte), 7 (excelente)
    public int medir(String pswd) {
        int eval = 0;

        // Si la contraseña tiene menos de 5 caracteres, se considera inválida
        if (pswd.length() >= 5) {

            // Comprobar si la contraseña contiene letras minúsculas
            if (pswd.matches(".*[a-z].*")) {
                eval++;
            }

            // Comprobar si la contraseña contiene letras mayúsculas
            if (pswd.matches(".*[A-Z].*")) {
                eval++;
            }

            // Comprobar si la contraseña contiene dígitos
            if (pswd.matches(".*\\d.*")) {
                eval++;
            }

            // Comprobar si la contraseña contiene caracteres especiales
            if (pswd.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                eval++;
            }

            // Comprobar si la contraseña tiene 8 o más caracteres
            if (pswd.length() >= 8) {
                eval++;

                // Comprobar si la contraseña tiene 12 o más caracteres
                if (pswd.length() >= 12) {
                    eval++;

                    // Comprobar si la contraseña tiene 16 o más caracteres
                    if (pswd.length() >= 16) {
                        eval++;
                    }
                }
            }
        }
        return eval;
    }
}
