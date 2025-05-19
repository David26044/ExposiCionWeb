
package cursospringboot.domain;

/**
 * Clase POJO que representa un cliente en el sistema.
 * Contiene la información básica de un cliente incluyendo
 * su identificación, nombre, nombre de usuario y contraseña.
 */
public class Costumer {
    private Integer ID;
    private String name;
    private String username;
    private String password;

    /**
     * Constructor que inicializa todos los campos del cliente.
     *
     * @param ID Identificador único del cliente
     * @param name Nombre completo del cliente
     * @param username Nombre de usuario para el sistema
     * @param password Contraseña del cliente
     */
    public Costumer(int ID, String name, String username, String password) {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Getters y Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}