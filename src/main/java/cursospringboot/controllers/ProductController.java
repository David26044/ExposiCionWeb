package cursospringboot.controllers;

import cursospringboot.domain.Product;
import cursospringboot.service.ProductService;
import cursospringboot.service.ProductsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductController {

    private ProductService productsService = new ProductsServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(productsService.getProducts());
    }

    @GetMapping("/{ID}")
    public ResponseEntity<?> getProductById(@PathVariable Integer ID) {
        Product product = productsService.getProductById(ID);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product newProduct = productsService.addProduct(product);
        if (newProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        Product updated = productsService.updateProduct(product);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<?> deleteProduct(@PathVariable int ID) {
        Product deletedProduct = productsService.deleteProductById(ID);
        if (deletedProduct != null) {
            return ResponseEntity.ok(deletedProduct);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }

    @PatchMapping
    public ResponseEntity<?> patchProduct(@RequestBody Product partialProduct) {
        Product patched = productsService.patchProduct(partialProduct);
        if (patched != null) {
            return ResponseEntity.ok(patched);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }
    
}
