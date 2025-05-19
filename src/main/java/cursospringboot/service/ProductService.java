package cursospringboot.service;

import cursospringboot.domain.Product;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la gestión de productos.
 */
public interface ProductService {

    /**
     * Obtiene todos los productos disponibles
     * @return Lista de productos
     */
    public List<Product> getProducts();

    /**
     * Busca un producto por su ID
     * @param id Identificador del producto
     * @return Producto encontrado o null si no existe
     */
    public Product getProductById(Integer id);

    /**
     * Agrega un nuevo producto
     * @param product Producto a agregar
     * @return Producto agregado o null si falla
     */
    public Product addProduct(Product product);

    /**
     * Actualiza toda la información de un producto
     * @param product Producto con datos actualizados
     * @return Producto actualizado o null si no existe
     */
    public Product updateProduct(Product product);

    /**
     * Elimina un producto por su ID
     * @param id ID del producto a eliminar
     * @return Producto eliminado o null si no existe
     */
    public Product deleteProductById(Integer id);

    /**
     * Actualiza parcialmente un producto
     * @param partialProduct Producto con campos a actualizar
     * @return Producto actualizado o null si no existe
     */
    public Product patchProduct(Product partialProduct);
}