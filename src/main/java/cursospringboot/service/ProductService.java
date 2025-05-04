package cursospringboot.service;

import cursospringboot.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();
    //public Product getProduct(Integer id);
}
