package cursospringboot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cursospringboot.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Primary
@Service("jsonResourceService")
public class ProductsServiceJSONImpl implements ProductService {
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

    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProductById(Integer id) {
        return null;
    }

    @Override
    public Product patchProduct(Product partialProduct) {
        return null;
    }
}
