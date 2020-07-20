package by.jrr.controller.controller_service;

import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import by.jrr.stat.HTTP;
import by.jrr.stat.Success;
import org.springframework.ui.Model;

public class SetNewProduct {
    public static String setNewProduct(Model model, ProductRepository productRepository, String category, Product product) {
        product.setCategory(category);
        productRepository.save(product);

        model.addAttribute("message", Success.PRODUCT_ADDED);
        return HTTP.SUCCESS;
    }
}
