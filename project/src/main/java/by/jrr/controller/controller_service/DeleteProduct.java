package by.jrr.controller.controller_service;

import by.jrr.repository.ProductRepository;
import by.jrr.stat.Success;
import org.springframework.ui.Model;

public class DeleteProduct {
    public static String deleteProduct(Model model, ProductRepository productRepository, Long id) {
        productRepository.deleteById(id);
        model.addAttribute("message", Success.PRODUCT_DELETE);
        return "success";
    }
}
