
package cursospringboot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cursospringboot.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

/**
 * Implementación del servicio de productos que gestiona el acceso a datos desde un archivo JSON.
 * Esta implementación está marcada como @Primary, lo que significa que será la implementación preferida
 * cuando existan múltiples implementaciones de ProductService.
 */
@Primary
@Service("jsonResourceService")
public class ProductsServiceJSONImpl implements ProductService {

    /**
     * Obtiene la lista de productos desde un archivo JSON.
     * Lee y deserializa los productos desde 'products.json' en el classpath.
     *
     * @return Lista de productos leída desde el archivo JSON
     * @throws RuntimeException si ocurre un error durante la lectura del archivo
     */
    @Override
    public List<Product> getProducts() {
        List<Product> products;

        try {
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {});
            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca un producto por su identificador.
     * Nota: Actualmente no implementado.
     *
     * @param id Identificador del producto
     * @return null ya que no está implementado
     */
    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    /**
     * Agrega un nuevo producto.
     * Nota: Actualmente no implementado.
     *
     * @param product Producto a agregar
     * @return null ya que no está implementado
     */
    @Override
    public Product addProduct(Product product) {
        return null;
    }

    /**
     * Actualiza la información de un producto existente.
     * Nota: Actualmente no implementado.
     *
     * @param product Producto con los datos actualizados
     * @return null ya que no está implementado
     */
    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    /**
     * Elimina un producto por su identificador.
     * Nota: Actualmente no implementado.
     *
     * @param id Identificador del producto a eliminar
     * @return null ya que no está implementado
     */
    @Override
    public Product deleteProductById(Integer id) {
        return null;
    }

    /**
     * Actualiza parcialmente un producto.
     * Nota: Actualmente no implementado.
     *
     * @param partialProduct Producto con los campos a actualizar
     * @return null ya que no está implementado
     */
    @Override
    public Product patchProduct(Product partialProduct) {
        return null;
    }
}