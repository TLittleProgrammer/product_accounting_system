package by.jrr.controller.controller_service;

import by.jrr.bean.Category;
import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import org.springframework.ui.Model;

public class ShowProductPage {
    public static String showProductPage(Model model, ProductRepository productRepository, String id) {
        Product product = productRepository.findById(Long.valueOf(id)).get();

        model.addAttribute("product", product);
        model.addAttribute("categories", Category.values());
        return "show_product";
    }
}
