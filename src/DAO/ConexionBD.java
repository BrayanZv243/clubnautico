/**
 * ConexionBD.java
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Esta clase nos permite crear la conexión a la BD de MySQL Workbench, e
 * implementa los métodos de la interfaz iConexionBD.
 *
 * @author Brayan Zavala 00000228311
 */
public class ConexionBD implements iConexionBD {

    public String cadenaConexion = "jdbc:mysql://localhost/clubnautico";
    public String usuario = "root";
    public String password = "Lablanquita123";

    /**
     * Constructor por omisión-
     */
    public ConexionBD() {
    }

    /**
     * Crea la conexión a la BD de MySQL Workbench.
     *
     * @return La conexión establecida.
     */
    @Override
    public Connection crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
            return conexion;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

}
