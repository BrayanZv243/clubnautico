/**
 * Socio.java
 */
package DAO;

/**
 * Clase que representa al socio.
 *
 * @author Brayan Zavala 00000228311
 */
public class Socio {

    public int idSocio;
    public String Nombre;
    public String Direccion;
    public String Telefono;
    //AQUI MODIFICASTE XD
    public String telefono2;

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     * Constructor por omisión.
     */
    public Socio() {
    }

    /**
     * Constructor que crea al objeto socio.
     *
     * @param idSocio ID del socio.
     * @param Nombre Nombre del socio.
     * @param Direccion La dirección del socio.
     * @param Telefono El teléfono del socio.
     */
    public Socio(int idSocio, String Nombre, String Direccion, String Telefono) {
        this.idSocio = idSocio;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    /**
     * Obtiene el ID del socio.
     *
     * @return El ID del socio.
     */
    public int getIdSocio() {
        return idSocio;
    }

    /**
     * Establece el ID del socio.
     *
     * @param idSocio El ID del socio.
     */
    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    /**
     * Obtiene el nombre del socio.
     *
     * @return El nombre del socio.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Establece el nombre del socio.
     *
     * @param Nombre El nombre del socio.
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * Obtiene la dirección del socio.
     *
     * @return La dirección del socio.
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * Establece la dirección del socio.
     *
     * @param Direccion La dirección del socio.
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * Obtiene el teléfono del socio.
     *
     * @return El teléfono del socio.
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * Establece el teléfono del socio.
     *
     * @param Telefono El teléfono del socio.
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

}
