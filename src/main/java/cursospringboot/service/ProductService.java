package cursospringboot.service;

import cursospringboot.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();
    public Product getProductById(Integer id);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProductById(Integer id);
    public Product patchProduct(Product partialProduct);
}
