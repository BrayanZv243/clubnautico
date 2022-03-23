/**
 * IConexionBD
 */
package DAO;

import java.sql.Connection;

/**
 * Esta interfaz crea la conexión con la Base de Datos.
 *
 * @author Brayan Zavala 00000228311
 */
public interface iConexionBD {

    Connection crearConexion();

}
