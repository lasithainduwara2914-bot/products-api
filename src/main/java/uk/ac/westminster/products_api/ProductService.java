package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }
    public java.util.Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    // Delete product by ID
    public boolean deleteProductById(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
    // Search products by name (case-insensitive)
    public List<Product> searchProducts(String query) {
        return products.stream()
                .filter(p -> p.getName() != null && p.getName().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }
}