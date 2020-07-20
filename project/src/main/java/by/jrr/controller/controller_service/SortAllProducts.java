package by.jrr.controller.controller_service;

import by.jrr.bean.Category;
import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import by.jrr.sort.Sort;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

public class SortAllProducts {
    public static String sortAllProducts(Model model, ProductRepository productRepository, String sortType) {
        List<Product> products = productRepository.findAll();
        switch (sortType) {
            case "price" : products.sort(Sort.sortByPrice); break;
            case "discount" : products.sort(Sort.sortByDiscount); break;
            case "category" : products.sort(Sort.sortByCategory); break;
        }
        Collections.reverse(products);
        model.addAttribute("products", products);
        model.addAttribute("categories", Category.values());
        model.addAttribute(new Product());

        return "main";
    }
}
