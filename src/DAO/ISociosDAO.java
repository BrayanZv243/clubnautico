/**
 * ISociosDAO.java
 */
package DAO;

import java.util.List;

/**
 * Interfaz que permite acceder a la BD.
 *
 * @author Brayan Zavala 00000228311
 */
public interface ISociosDAO {

    boolean agregar(Socio socio);

    boolean actualizar(Socio socio);

    boolean eliminar(Socio socio);

    int consultarUltimoRegistroID();

    List<Socio> consultarTodos();
}
