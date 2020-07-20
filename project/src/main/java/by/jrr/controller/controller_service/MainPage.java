package by.jrr.controller.controller_service;

import by.jrr.bean.Category;
import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import org.springframework.ui.Model;

import java.util.List;

public class MainPage {
    public static String mainPage(Model model, ProductRepository productRepository) {
        List<Product> iterable = productRepository.findAll();
        model.addAttribute("products", iterable);
        model.addAttribute("categories", Category.values());
        model.addAttribute(new Product());
        return "main";
    }
}
