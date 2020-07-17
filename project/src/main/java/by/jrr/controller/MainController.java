package by.jrr.controller;

import by.jrr.bean.Category;
import by.jrr.bean.Product;
import by.jrr.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping({"/", "/main"})
    public String main(Model model) {
        Iterable<Product> iterable = productRepository.findAll();
        model.addAttribute("products", iterable);
        model.addAttribute("categories", Category.values());
        model.addAttribute(new Product());
        return "main";
    }

    @PostMapping("/show_product")
    public String mainGetProductById(@ModelAttribute("id") Long id, Model model) {
        Optional<Product> iterable = productRepository.findById(id);
        ArrayList<Product> product = new ArrayList<>();
        iterable.ifPresent(product::add);

        model.addAttribute("product", product.get(0));
        model.addAttribute("categories", Category.values());
        return "show_product";
    }

}
