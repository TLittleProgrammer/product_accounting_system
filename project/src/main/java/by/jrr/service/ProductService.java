package by.jrr.service;

import by.jrr.bean.Category;
import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;

import java.util.List;

public class ProductService implements ProductRepository {
    @Override
    public void setProduct(Product product) {

    }

    @Override
    public void removeProductById(Long id) {

    }

    @Override
    public void changePriceProductById(Long id) {

    }

    @Override
    public void setDiscountProductById(Long id) {

    }

    @Override
    public void removeDiscountProductById(Long id) {

    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getAllProductsByCategory(Category category) {
        return null;
    }
}
