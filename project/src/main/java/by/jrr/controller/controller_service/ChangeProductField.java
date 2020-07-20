package by.jrr.controller.controller_service;

import by.jrr.bean.Category;
import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import by.jrr.service.ProductService;
import org.springframework.ui.Model;

import java.util.List;

public class ChangeProductField {
    private static ProductService productService = new ProductService();

    public static String changeProductField(Model model, ProductRepository productRepository, String field, String newValue, Long id) {
        switch (field) {
            case "name" : productService.changeName(id, newValue, productRepository); break;
            case "category" : productService.changeCategory(id, newValue, productRepository); break;
            case "price" : productService.changePrice(id, newValue, productRepository); break;
            case "discount" : productService.changeDiscount(id, newValue, productRepository); break;
            case "description" :  productService.changeDescription(id, newValue, productRepository); break;
        }
        List<Product> iterable = productRepository.findAll();
        model.addAttribute("products", iterable);
        model.addAttribute("categories", Category.values());
        model.addAttribute(new Product());
        return "main";
    }
}
