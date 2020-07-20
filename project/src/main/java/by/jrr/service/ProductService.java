package by.jrr.service;

import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import by.jrr.repository.ProductServiceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService implements ProductServiceRepository {

    private Product foundProduct = new Product();

    @Override
    public void changeName(Long id, String newValue, ProductRepository productRepository) {
        getProductById(id, productRepository);
        foundProduct.setName(newValue);
        productRepository.save(foundProduct);
    }

    @Override
    public void changeCategory(Long id, String newValue, ProductRepository productRepository) {
        getProductById(id, productRepository);
        foundProduct.setCategory(newValue);
        productRepository.save(foundProduct);
    }

    @Override
    public void changePrice(Long id, String newValue, ProductRepository productRepository) {
        getProductById(id, productRepository);
        foundProduct.setPrice(BigDecimal.valueOf(Long.parseLong(newValue)));
        productRepository.save(foundProduct);
    }

    @Override
    public void changeDiscount(Long id, String newValue, ProductRepository productRepository) {
        getProductById(id, productRepository);
        foundProduct.setDiscount(BigDecimal.valueOf(Long.parseLong(newValue)));
        productRepository.save(foundProduct);
    }

    @Override
    public void changeDescription(Long id, String newValue, ProductRepository productRepository) {
        getProductById(id, productRepository);
        foundProduct.setDescription(newValue);
        productRepository.save(foundProduct);
    }

    private void getProductById(Long id, ProductRepository productRepository) {
        foundProduct = productRepository.findById(id).get();
    }
}
