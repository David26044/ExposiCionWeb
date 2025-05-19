package cursospringboot.domain;

/**
 * Clase que representa un producto en el sistema.
 */
public class Product {

    private Integer id;        // Identificador único del producto
    private String name;       // Nombre del producto
    private Double price;      // Precio del producto
    private int stock;        // Cantidad disponible en inventario

    /**
     * Constructor con todos los campos
     */
    public Product(Integer id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Constructor por defecto
     */
    public Product(){}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}