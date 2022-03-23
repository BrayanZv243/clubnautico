/**
 * SociosDAO.java
 */
package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * Esta clase implementa los métodos de la interfaz ISociosDAO. Implementamos
 * métodos CRUD para la BD.
 *
 * @author Brayan Zavala 00000228311
 */
public class SociosDAO implements ISociosDAO {

    public iConexionBD conexion = new ConexionBD();

    /**
     * Constructor por omisión.
     */
    public SociosDAO() {
    }

    /**
     * Constructor que recibe como parametro la conexión.
     *
     * @param conexion La conexión a la BD.
     */
    public SociosDAO(iConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega a la base de datos clubnautico el idSocio, nombre, dirección y su
     * teléfono.
     *
     * @param socio El objeto socio a agregar.
     * @return Verdadero si lo agregó correctamente, falso en caso contrario.
     */
    @Override
    public boolean agregar(Socio socio) {
        try {
            String query = "INSERT INTO `clubnautico` (`idSocio`, `Nombre`, `Direccion`, `Telefono`) "
                    + "VALUES ('" + socio.idSocio + "', '" + socio.Nombre + "', '" + socio.Direccion + "', '" + socio.Telefono + "')";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            con.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    /**
     * Actualiza a la base de datos clubnautico el idSocio, nombre, dirección y
     * su teléfono. En este caso en vez de usar una simple query, usamos un
     * stored procedure
     *
     * @param socio El objeto socio a actualizar.
     * @return Verdadero si lo actualizó correctamente, falso en caso contrario.
     */
    @Override
    public boolean actualizar(Socio socio) {
        try {
            String query = "CALL Actualiza_Socio(" + socio.idSocio + ",'" + socio.Nombre + "','" + socio.Direccion + "','" + socio.Telefono + "')";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            con.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

    }

    /**
     * Elimina de la base de datos clubnautico el idSocio, nombre, dirección y
     * su teléfono. En este caso en vez de usar una simple query, usamos un
     * stored procedure
     *
     * @param socio El objeto socio a eliminar.
     * @return Verdadero si lo eliminó correctamente, falso en caso contrario.
     */
    @Override
    public boolean eliminar(Socio socio) {
        try {
            String query = "CALL Elimina_Socio(" + socio.idSocio + ")";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            con.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

    }

    /**
     * Consulta la lista de la BD completa con un query a la BD.
     *
     * @return La lista de todos los socios en la BD.
     */
    @Override
    public List<Socio> consultarTodos() {
        try {
            List<Socio> list = new ArrayList();
            String query = "SELECT * FROM clubnautico";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            while (datos.next()) {
                Socio socio = new Socio();
                socio.idSocio = datos.getInt("idSocio");
                socio.Nombre = datos.getString("Nombre");
                socio.Direccion = datos.getString("Direccion");
                socio.Telefono = datos.getString("Telefono");
                list.add(socio);

            }
            con.close();

            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Consulta el último registro para obtener su ID y autoincrementar dicho ID
     * automátiamente.
     *
     * @return El ID siguiente al último ID creado.
     */
    @Override
    public int consultarUltimoRegistroID() {
        int id = 0;
        try {
            String query = "SELECT * FROM clubnautico ORDER by idSocio DESC LIMIT 1";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            while (datos.next()) {
                id = datos.getInt("idSocio");
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);

        }
        return id;
    }

}
