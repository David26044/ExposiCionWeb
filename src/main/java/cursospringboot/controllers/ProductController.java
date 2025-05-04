package cursospringboot.controllers;

import cursospringboot.service.ProductService;
import cursospringboot.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductController {

    //ProductService productsService = new ProductsServiceImpl();
    @Autowired //Inyeccion de dependencias por campo
    @Qualifier("listResourceService")
    private ProductService productsService;

    @GetMapping
    public ResponseEntity<?> getProducts() {

        return ResponseEntity.ok(productsService.getProducts());
    }

}
