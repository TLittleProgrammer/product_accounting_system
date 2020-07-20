package by.jrr.controller.controller_service;

import by.jrr.bean.Category;
import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import by.jrr.stat.HTTP;
import by.jrr.stat.Mistake;
import org.springframework.ui.Model;

public class ShowProductPage {
    public static String showProductPage(Model model, ProductRepository productRepository, String id) {
        Product product = productRepository.findById(Long.valueOf(id)).get();

        if(product == null) {
            model.addAttribute("message", Mistake.MISTAKE_NO_SUCH_PRODUCT_EXISTS);
            return HTTP.EXCEPTION;
        }

        model.addAttribute("product", product);
        model.addAttribute("categories", Category.values());
        return "show_product";
    }
}