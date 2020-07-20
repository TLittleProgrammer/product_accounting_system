package by.jrr.controller.controller_service;

import by.jrr.repository.ProductRepository;
import by.jrr.stat.Attributes;
import by.jrr.stat.HTTP;
import by.jrr.stat.Success;
import org.springframework.ui.Model;

public class DeleteAllProducts {
    public static String deleteAllProducts(Model model, ProductRepository productRepository) {
        productRepository.deleteAll();
        model.addAttribute(Attributes.MESSAGE, Success.REMOVED_ALL_PRODUCTS);
        return HTTP.SUCCESS;
    }
}
