package cursospringboot.controllers;

import cursospringboot.domain.Product;
import cursospringboot.service.ProductService;
import cursospringboot.service.ProductsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestión de productos.
 * Proporciona operaciones CRUD en la ruta /productos
 */
@RestController
@RequestMapping("/productos")
public class ProductController {

    private ProductService productsService = new ProductsServiceImpl();

    /**
     * @return Lista de todos los productos
     */
    @GetMapping
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(productsService.getProducts());
    }

    /**
     * @param ID Identificador del producto
     * @return Producto encontrado o 404 si no existe
     */
    @GetMapping("/{ID}")
    public ResponseEntity<?> getProductById(@PathVariable Integer ID) {
        Product product = productsService.getProductById(ID);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /**
     * @param product Datos del nuevo producto
     * @return Producto creado o error 500 si falla
     */
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product newProduct = productsService.addProduct(product);
        if (newProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * @param product Producto con datos actualizados
     * @return Producto actualizado o 404 si no existe
     */
    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        Product updated = productsService.updateProduct(product);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }

    /**
     * @param ID Identificador del producto a eliminar
     * @return Producto eliminado o 404 si no existe
     */
    @DeleteMapping("/{ID}")
    public ResponseEntity<?> deleteProduct(@PathVariable int ID) {
        Product deletedProduct = productsService.deleteProductById(ID);
        if (deletedProduct != null) {
            return ResponseEntity.ok(deletedProduct);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }

    /**
     * @param partialProduct Producto con campos a actualizar
     * @return Producto actualizado o 404 si no existe
     */
    @PatchMapping
    public ResponseEntity<?> patchProduct(@RequestBody Product partialProduct) {
        Product patched = productsService.patchProduct(partialProduct);
        if (patched != null) {
            return ResponseEntity.ok(patched);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }
}