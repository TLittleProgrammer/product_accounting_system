package by.jrr.repository;


import by.jrr.bean.Category;
import by.jrr.bean.Product;
import java.util.List;

public interface ProductRepository {
    void setProduct(Product product);
    void removeProductById(Long id);
    void changePriceProductById(Long id);
    void setDiscountProductById(Long id);
    void removeDiscountProductById(Long id);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getAllProductsByCategory(Category category);
}
