package by.jrr.controller.controller_service;

import by.jrr.bean.Category;
import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import org.springframework.ui.Model;

import java.util.LinkedList;
import java.util.List;

public class FindProductBy {
    public static String findProductBy(Model model, ProductRepository productRepository, String category) {
        List<Product> productsAll = productRepository.findAll();
        List<Product> products = new LinkedList<>();
        if(!category.equals("all"))
            for (Product product : productsAll)
                if(product.getCategory().equals(category))
                    products.add(product);
        if(products.size() == 0)
            products = productsAll;

        model.addAttribute("products", products);
        model.addAttribute("categories", Category.values());
        model.addAttribute(new Product());

        return "main";
    }
}
