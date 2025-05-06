package cursospringboot.service;

import cursospringboot.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("listResourceService")
public class ProductsServiceImpl implements ProductService {


    private List<Product> products= new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 799.99,10),
            new Product(2, "Smartphone", 499.99, 25),
            new Product(3, "Tablet", 299.99, 15),
            new Product(4, "Smartwatch", 199.99,30)
    ));

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductById(Integer id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

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

    @Override
    public Product patchProduct(Product partialProduct) {
        for (Product existingProduct : products) {
            if (existingProduct.getId().equals(partialProduct.getId())) {

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
