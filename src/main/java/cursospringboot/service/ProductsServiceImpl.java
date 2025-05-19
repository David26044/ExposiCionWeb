
package cursospringboot.service;

import cursospringboot.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementación del servicio de productos que gestiona el almacenamiento y operaciones CRUD.
 * Utiliza una lista en memoria como almacenamiento temporal para demostración.
 */
@Service("listResourceService")
public class ProductsServiceImpl implements ProductService {

    /**
     * Almacenamiento en memoria de productos con datos de ejemplo.
     * Simula una base de datos con productos predefinidos para demostración.
     */
    private List<Product> products= new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 799.99,10),
            new Product(2, "Smartphone", 499.99, 25),
            new Product(3, "Tablet", 299.99, 15),
            new Product(4, "Smartwatch", 199.99,30)
    ));

    /**
     * Obtiene la lista completa de productos.
     *
     * @return Lista con todos los productos disponibles
     */
    @Override
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Busca un producto por su identificador.
     *
     * @param id Identificador único del producto
     * @return Producto encontrado o null si no existe
     */
    @Override
    public Product getProductById(Integer id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Agrega un nuevo producto al almacenamiento.
     *
     * @param product Nuevo producto a agregar
     * @return El producto agregado
     */
    @Override
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    /**
     * Actualiza toda la información de un producto existente.
     * Solo actualiza nombre y precio del producto.
     *
     * @param product Producto con los nuevos datos
     * @return Producto actualizado o null si no se encuentra
     */
    @Override
    public Product updateProduct(Product product) {
        for(Product product2 : products) {
            if (product2.getId().equals(product.getId())) {
                product2.setPrice(product.getPrice());
                product2.setName(product.getName());
                return product2;
            }
        }
        return null;
    }

    /**
     * Elimina un producto del almacenamiento por su ID.
     *
     * @param id Identificador del producto a eliminar
     * @return Producto eliminado o null si no se encuentra
     */
    @Override
    public Product deleteProductById(Integer id) {
        for(Product product2 : products) {
            if (product2.getId().equals(id)) {
                products.remove(product2);
                return product2;
            }
        }
        return null;
    }

    /**
     * Actualiza parcialmente un producto existente.
     * Solo actualiza los campos que no son nulos o tienen valores por defecto.
     *
     * @param partialProduct Producto con los campos a actualizar
     * @return Producto actualizado o null si no se encuentra
     */
    @Override
    public Product patchProduct(Product partialProduct) {
        for (Product existingProduct : products) {
            if (existingProduct.getId().equals(partialProduct.getId())) {
                // Actualiza solo los campos que no son nulos
                if (partialProduct.getName() != null) {
                    existingProduct.setName(partialProduct.getName());
                }
                if (partialProduct.getPrice() == null) {
                    existingProduct.setPrice(partialProduct.getPrice());
                }
                if (partialProduct.getStock() != 0) {
                    existingProduct.setStock(partialProduct.getStock());
                }
                return existingProduct;
            }
        }
        return null;
    }
}