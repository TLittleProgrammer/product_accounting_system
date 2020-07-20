package by.jrr.repository;

public interface ProductServiceRepository {
    void changeName(Long id, String newValue, ProductRepository productRepository);
    void changeCategory(Long id, String newValue, ProductRepository productRepository);
    void changePrice(Long id, String newValue, ProductRepository productRepository);
    void changeDiscount(Long id, String newValue, ProductRepository productRepository);
    void changeDescription(Long id, String newValue, ProductRepository productRepository);
}
