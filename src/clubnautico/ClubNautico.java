/**
 * ClubNautico.java
 */
package clubnautico;

import Formularios.GestionSocios;

/**
 * Clase Main para abrir la interfaz del programa.
 *
 * @author Brayan Zavala 00000228311
 */
public class ClubNautico {

    /**
     * Método main para abrir la interfaz del programa.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        GestionSocios gestion = new GestionSocios();
        gestion.setVisible(true);
    }

}
